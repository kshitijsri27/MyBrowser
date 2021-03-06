package com.Kshitij.MyBrowser;

import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class Browser extends JFrame {

	private TextField addressBar = new TextField();
	private JEditorPane webPages = new JEditorPane();	//to view and read HTML files
	private JScrollPane scrollWebPages = new JScrollPane(webPages);
	
	public static void main(String[] args) {
		
			Browser browse = new Browser();
			browse.browseFunction();
	}

	private void browseFunction() {
		
		setTitle("MyBrowser");		//name of my browser
		setSize(1280, 880);		   //window size 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//exit method
		setVisible(true);		//to make frame visible
		setResizable(true);		//user can resize the browser
		setLayout(null);		//
		setLocationRelativeTo(null);
		addComponentsToFrame(getContentPane());
	}

	public void addComponentsToFrame(Container contentPane) {
		
		Insets insets = getInsets();
		
		//adding text fields and panes to the frame
		contentPane.add(addressBar);
		contentPane.add(scrollWebPages);
		
		//styling
		Font fontStyle = new Font("Callibri Body", Font.BOLD, 12);
		addressBar.setFont(fontStyle);
		addressBar.setBounds(8-insets.left, 30-insets.top, 1268, 20);
		scrollWebPages.setBounds(8-insets.left, 52-insets.top, 1268, 830);
		
		ActionListenerCalls();
	}

	private void ActionListenerCalls()
	{
		addressBar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				loadData("http://" + e.getActionCommand());
			}
		});
		
		webPages.addHyperlinkListener(new HyperlinkListener() {
			
			@Override
			public void hyperlinkUpdate(HyperlinkEvent e) {
				
				if(e.getEventType()==HyperlinkEvent.EventType.ACTIVATED){
					
					loadData(e.getURL().toString());
				}
				
			}
		});
	}
	
	private void loadData(String URL){
		
		try{
			
			webPages.setPage(URL);
		}
		
		catch(Exception e){
			
			System.out.println("Sorry pal invalid search");
		}
	}
}
