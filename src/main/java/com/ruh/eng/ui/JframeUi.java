package com.ruh.eng.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by DimRu on 15-Jun-17.
 *
 */
public class JframeUi
{
	//JFrame mFrame = new JFrame(  );
	
	public void createUI() {
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		
	JButton openBtn = new JButton("Open");
		
		openBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser openFile = new JFileChooser();
				openFile.showOpenDialog(null);
			}
		});
		
		frame.add(new JLabel("File Chooser"), BorderLayout.NORTH);
		frame.add(openBtn, BorderLayout.SOUTH);
		frame.setTitle("File Chooser");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
