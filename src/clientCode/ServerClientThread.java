package clientCode;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.Vector;
import java.io.*;

import javax.swing.*;

public class ServerClientThread extends Thread implements Runnable{
	int playerID;
	Socket acceptedSocket;
	JTextArea textArea;
	Vector<Player> players;
	Player me;

	public ServerClientThread(Socket acceptedSocket, Vector<Player> players, int playerID, JTextArea textArea){
		super("ClientThread");
		this.acceptedSocket = acceptedSocket;
		this.players = players;
		players.add(new Player(50,50, playerID));

		if(players != null)
			System.out.println("Not Null: " + players.size());

		boolean b = false;
		for(int i = 0; i < players.size(); i++){
			if(!b){
				if(players.get(i).id == playerID){
					me = players.get(i);
					b = true;
				}
			}
		}

		this.playerID = playerID;
		this.textArea = textArea;
	}

	public void removeMeAndClose(){
		boolean b = false;
		for(int i = 0; i < players.size(); i++){
			if(!b){
				if(players.get(i).id == playerID){
					players.remove(i);
					b = true;
				}
			}
		}

		try{
			acceptedSocket.close();
		}

		catch(Exception ee){
			ee.printStackTrace();
		}
	}

	public void run(){
		try{
			Socket clientSocket = acceptedSocket;
			clientSocket.setTcpNoDelay(true);
			textArea.append("Accepted. Now creating I/O.\n");
			DataInputStream in = new DataInputStream(clientSocket.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
			textArea.append("player connected. \n");
			out.writeInt(me.id);
			out.writeObject(players);
			out.flush();
			while(!clientSocket.isClosed() && clientSocket.isConnected()){
				try{
					me.xPos = in.readInt();
					me.yPos = in.readInt();

					//if(players != null)
					//System.out.println("Not Null: " + players.size());

					textArea.append("PlayerID: " + playerID + " Players: " + players.size() + " me.x: " + me.xPos + " me.y: " + me.yPos + "\n");

					out.reset();
					out.writeObject(players);
					out.flush();

					sleep(15);
				}

				catch(Exception e){
					removeMeAndClose();
				}
			}

		}

		catch(Exception e){
			removeMeAndClose();
		}


	}

}