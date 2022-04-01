import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.*;
import java.io.*;
import javax.swing.text.*;

class TimeTable{
	
	private JFrame progressf,confirmf,informf,f;
	private JTextField ForFirstFocusOnly;
	private ImageIcon i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i14,i15,i16,i17,i18,i19,i20;
	private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
	private JProgressBar pb1;
	private JPanel p1,p2,p3,p4,p5,p6,p7,p8,ep[];
	private JScrollBar sb1,sb2,sb3,sb4,sb5,sb6;
	private int PTTcount = 0,dragX,dragY;
	private DateFormat dateFormat;
	private String confirmfBy;
	
	private ArrayList<JPanel> PTT = new ArrayList<JPanel>();
	private ArrayList<JLabel> PTTname = new ArrayList<JLabel>();
	private ArrayList<JLabel> PTTdate = new ArrayList<JLabel>();
	private ArrayList<JButton> PTTdeleteKey = new ArrayList<JButton>();
	private ArrayList<JButton> PTTeditKey = new ArrayList<JButton>();
	private ArrayList<JButton> PTTshowKey = new ArrayList<JButton>();
	
	private ImageIcon i21;
	private JTextField title,addTeacherCount,addSubjectCount;
	private JButton removeTeacher,addTeacher,removeSubject,addSubject;
	private ArrayList<JTextField> teacherNameInput = new ArrayList<JTextField>();
	private ArrayList<JButton> teacherNameCross = new ArrayList<JButton>();
	private int lastFocused = 0,lastFocused1 = 0,lastFocused2 = 0,lastFocused3 = 0,lastFocused4 = 0;
	private JLabel subjectDefaultLabel[] = new JLabel[4];
	private JTextField subjectDefaultText[] = new JTextField[4];
	private ArrayList<JTextField> subjectNameInput = new ArrayList<JTextField>();
	private ArrayList<JButton> subjectNameCross = new ArrayList<JButton>();
	private ArrayList<JCheckBox> haveLecture = new ArrayList<JCheckBox>();
	private ArrayList<JCheckBox> havePractical = new ArrayList<JCheckBox>();
	private ArrayList<JTextField> timePerLecture = new ArrayList<JTextField>();
	private ArrayList<JTextField> lecturePerWeek = new ArrayList<JTextField>();
	private ArrayList<JTextField> timePerPractical = new ArrayList<JTextField>();
	private ArrayList<JTextField> practicalPerWeek = new ArrayList<JTextField>();
	private JLabel noteShortForm;
	
	private ImageIcon i22,i23;
	private JButton classInputAdd = new JButton();
	private ArrayList<JButton> divisionInputAdd = new ArrayList<JButton>();
	private ArrayList<ArrayList<JButton>> subjectChooseAdd = new ArrayList<ArrayList<JButton>>();
	private ArrayList<ArrayList<ArrayList<JButton>>> subjectTeacherChooseAdd = new ArrayList<ArrayList<ArrayList<JButton>>>();
	private ArrayList<JPanel> classInputPanel = new ArrayList<JPanel>();
	private ArrayList<JTextField> classInput = new ArrayList<JTextField>();
	private ArrayList<JButton> classInputCross = new ArrayList<JButton>();
	private ArrayList<ArrayList<JPanel>> divisionInputPanel = new ArrayList<ArrayList<JPanel>>();
	private ArrayList<ArrayList<JTextField>> divisionInput = new ArrayList<ArrayList<JTextField>>();
	private ArrayList<ArrayList<JButton>> divisionInputCross = new ArrayList<ArrayList<JButton>>();
	private ArrayList<ArrayList<ArrayList<JPanel>>> subjectChoosePanel = new ArrayList<ArrayList<ArrayList<JPanel>>>();
	private ArrayList<ArrayList<ArrayList<JComboBox>>> subjectChoose = new ArrayList<ArrayList<ArrayList<JComboBox>>>();
	private ArrayList<ArrayList<ArrayList<JButton>>> subjectChooseCross = new ArrayList<ArrayList<ArrayList<JButton>>>();
	private ArrayList<ArrayList<ArrayList<ArrayList<JPanel>>>> subjectTeacherChoosePanel = new ArrayList<ArrayList<ArrayList<ArrayList<JPanel>>>>();
	private ArrayList<ArrayList<ArrayList<ArrayList<JComboBox>>>> subjectTeacherChoose = new ArrayList<ArrayList<ArrayList<ArrayList<JComboBox>>>>();
	private ArrayList<ArrayList<ArrayList<ArrayList<JButton>>>> subjectTeacherChooseCross = new ArrayList<ArrayList<ArrayList<ArrayList<JButton>>>>();
	private int lastSecondEditPanelSize = 364;
	
	private ArrayList<ArrayList<JButton>> batchInputAdd = new ArrayList<ArrayList<JButton>>();
	private ArrayList<ArrayList<ArrayList<JButton>>> practicalSubjectChooseAdd = new ArrayList<ArrayList<ArrayList<JButton>>>();
	private ArrayList<ArrayList<ArrayList<ArrayList<JButton>>>> practicalSubjectTeacherChooseAdd = new ArrayList<ArrayList<ArrayList<ArrayList<JButton>>>>();
	private ArrayList<ArrayList<ArrayList<JPanel>>> batchInputPanel = new ArrayList<ArrayList<ArrayList<JPanel>>>();
	private ArrayList<ArrayList<ArrayList<JTextField>>> batchInput = new ArrayList<ArrayList<ArrayList<JTextField>>>();
	private ArrayList<ArrayList<ArrayList<JButton>>> batchInputCross = new ArrayList<ArrayList<ArrayList<JButton>>>();
	private ArrayList<ArrayList<ArrayList<ArrayList<JPanel>>>> practicalSubjectChoosePanel = new ArrayList<ArrayList<ArrayList<ArrayList<JPanel>>>>();
	private ArrayList<ArrayList<ArrayList<ArrayList<JComboBox>>>> practicalSubjectChoose = new ArrayList<ArrayList<ArrayList<ArrayList<JComboBox>>>>();
	private ArrayList<ArrayList<ArrayList<ArrayList<JButton>>>> practicalSubjectChooseCross = new ArrayList<ArrayList<ArrayList<ArrayList<JButton>>>>();
	private ArrayList<ArrayList<ArrayList<ArrayList<ArrayList<JPanel>>>>> practicalSubjectTeacherChoosePanel = new ArrayList<ArrayList<ArrayList<ArrayList<ArrayList<JPanel>>>>>();
	private ArrayList<ArrayList<ArrayList<ArrayList<ArrayList<JComboBox>>>>> practicalSubjectTeacherChoose = new ArrayList<ArrayList<ArrayList<ArrayList<ArrayList<JComboBox>>>>>();
	private ArrayList<ArrayList<ArrayList<ArrayList<ArrayList<JButton>>>>> practicalSubjectTeacherChooseCross = new ArrayList<ArrayList<ArrayList<ArrayList<ArrayList<JButton>>>>>();
	private int lastThirdEditPanelSize = 364;
	
	private JPanel TTMainPanel,TTBackPanel,TTCoverPanel,TTRightSidePanel;
	private JLabel TTMainPanelBackground,TTRightSidePanelBackground,TTHomeButton,TTSaveButton,TTEditButton;
	private ImageIcon TTRightSideButtonIcon,TTRightSidePanelIcon,TTLeftSideButtonIcon,TTHomeIcon,TTSaveIcon,TTEditIcon,TTNextArrowIcon,TTBackArrowIcon;
	private JButton TTRightSideButton,TTLeftSideButton,TTNextArrow,TTBackArrow;
	private ArrayList<ArrayList<JPanel>> TTPanel = new ArrayList<ArrayList<JPanel>>();
	private ArrayList<ArrayList<JTextField>> TTHeading = new ArrayList<ArrayList<JTextField>>();
	private ArrayList<ArrayList<ArrayList<JTextField>>> TTTime = new ArrayList<ArrayList<ArrayList<JTextField>>>();
	private ArrayList<ArrayList<ArrayList<JTextField>>> TTDay = new ArrayList<ArrayList<ArrayList<JTextField>>>();
	
	public TimeTable(){
		
		f = new JFrame();
		f.setTitle("TimeTable");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1366,768);
		f.setLocationRelativeTo(null);
		f.setExtendedState(f.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		f.setLayout(null);
		i1 = new ImageIcon("IconsTimeTable\\timetable1.png");
		f.setIconImage(i1.getImage());
		
		ForFirstFocusOnly = new JTextField();
		f.add(ForFirstFocusOnly);
		
		dateFormat = new SimpleDateFormat("dd/MM/yyyy hh.mm aa");
		
		ShowProgressThread showProgressThread = new ShowProgressThread();
		showProgressThread.start();
		
		ProgressThread progressThread = new ProgressThread();
		progressThread.start();
		
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	public class ShowProgressThread extends Thread{
		public void run(){
			
			progressf = new JFrame("TimeTable Processing......");
			progressf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			progressf.setSize(800,500);
			progressf.setLocationRelativeTo(null);
			progressf.setLayout(null);
			progressf.setUndecorated(true);
			progressf.setIconImage(i1.getImage());
			
			i2 = new ImageIcon("IconsTimeTable\\timetable2.png");
			i2 = new ImageIcon(i2.getImage().getScaledInstance(600,250,java.awt.Image.SCALE_SMOOTH));
			l1 = new JLabel(i2);
			l1.setBounds(100,75,i2.getIconWidth(),i2.getIconHeight());
			progressf.add(l1);
			
			i3 = new ImageIcon("IconsTimeTable\\cross.png");
			i3 = new ImageIcon(i3.getImage().getScaledInstance(25,25,java.awt.Image.SCALE_SMOOTH));
			b1 = new JButton(i3);
			b1.setBounds(765,10,i3.getIconWidth(),i3.getIconHeight());
			b1.setOpaque(false);
			b1.setContentAreaFilled(false);
			b1.setBorderPainted(false);
			b1.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					System.exit(0);
				}
			});
			progressf.add(b1);
			
			i4 = new ImageIcon("IconsTimeTable\\background1.png");
			i4 = new ImageIcon(i4.getImage().getScaledInstance(800,500,java.awt.Image.SCALE_SMOOTH));
			l2 = new JLabel(i4);
			l2.setBounds(0,0,i4.getIconWidth(),i4.getIconHeight());
			progressf.add(l2);
			
			progressf.setVisible(true);
			
			int i=0;
			pb1=new JProgressBar(0,100);
			pb1.setBounds(30,325,740,15);
			pb1.setValue(0);
			pb1.setStringPainted(true);
			pb1.setBackground(new Color(204,255,255));
			pb1.setForeground(new Color(255,102,102));
			progressf.add(pb1);
			while(i<=100){
				pb1.setValue(i);
				i++;
				try{Thread.sleep(100);}catch(Exception e){}
			}
			
			progressf.dispose();
			f.setVisible(true);
			
		}
	}
	
	public class ProgressThread extends Thread{
		public void run(){
			
			ConfirmPage();
			InformPage();
			FirstPage();
			EditPage();
			LastPage();
			
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	public void FirstPage(){
		
		p1 = new JPanel();
		p1.setBounds(0,0,1366,768);
		p1.setBorder(new LineBorder(Color.black,1));
		p1.setLayout(null);
		f.add(p1);
		
		i6 = new ImageIcon("IconsTimeTable\\timetable2.png");
		i6 = new ImageIcon(i6.getImage().getScaledInstance(800,325,java.awt.Image.SCALE_SMOOTH));
		l4 = new JLabel(i6);
		l4.setBounds(50,0,i6.getIconWidth(),i6.getIconHeight());
		p1.add(l4);
		
		i7 = new ImageIcon("IconsTimeTable\\create_new_timetable_button.png");
		i7 = new ImageIcon(i7.getImage().getScaledInstance(450,100,java.awt.Image.SCALE_SMOOTH));
		b2 = new JButton(i7);
		b2.setBounds(833,165,i7.getIconWidth(),i7.getIconHeight());
		b2.setOpaque(false);
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(false);
		b2.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				p1.setVisible(false);
				p4.setVisible(true);
			}
		});
		p1.add(b2);
		
		PreviousTimeTable();
		
		i5 = new ImageIcon("IconsTimeTable\\background2.png");
		i5 = new ImageIcon(i5.getImage().getScaledInstance(1366,768,java.awt.Image.SCALE_SMOOTH));
		l3 = new JLabel(i5);
		l3.setBounds(0,0,1366,768);
		p1.add(l3);
		
	}
	
	public void PreviousTimeTable(){
		
		p2 = new JPanel();
		p2.setOpaque(false);
		p2.setBounds(100,300,1166,400);
		p2.setLayout(null);
		p1.add(p2);
		
		p3 = new JPanel();
		p3.setBounds(15,0,0,0);
		p3.setOpaque(false);
		p3.setLayout(null);
		p2.add(p3);
		
		p8 = new JPanel();
		p8.setBounds(15,0,1136,400);
		p8.setBackground(new Color(0.6f,0.8f,1.0f,0.4f));
		p8.setLayout(null);
		p2.add(p8);
		
		l10 = new JLabel("Data Not Found");
		l10.setBounds(0,0,1136,400);
		l10.setFont(new Font("TimesRoman",Font.BOLD,75));
		l10.setForeground(new Color(0.0f,0.0f,1.0f,0.1f));
		l10.setHorizontalAlignment(JLabel.CENTER);
		l10.setVerticalAlignment(JLabel.CENTER);
		p8.add(l10);
		
		i8 = new ImageIcon("IconsTimeTable\\delete_key.png");
		i8 = new ImageIcon(i8.getImage().getScaledInstance(100,65,java.awt.Image.SCALE_SMOOTH));
		i9 = new ImageIcon("IconsTimeTable\\edit_key.png");
		i9 = new ImageIcon(i9.getImage().getScaledInstance(100,65,java.awt.Image.SCALE_SMOOTH));
		i10 = new ImageIcon("IconsTimeTable\\show_key.png");
		i10 = new ImageIcon(i10.getImage().getScaledInstance(100,65,java.awt.Image.SCALE_SMOOTH));
		
		sb1 = new JScrollBar(JScrollBar.VERTICAL,1,100,0,1100);
		sb1.setBounds(0,0,15,400);
		sb1.setBackground(new Color(153,204,255));
		p2.add(sb1);
		
		sb2 = new JScrollBar(JScrollBar.VERTICAL,1,100,0,1100);
		sb2.setBounds(1151,0,15,400);
		sb2.setBackground(new Color(153,204,255));
		p2.add(sb2);
		
		sb1.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent e) {
				long temp = ((long)(400-p3.getHeight())*(long)sb1.getValue())/1000;
				int a = (int)temp;
				p3.setBounds(15,a,1136,p3.getHeight());
				sb2.setValue(sb1.getValue());
			}
		});
		
		sb2.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent e) {
				long temp = ((long)(400-p3.getHeight())*(long)sb1.getValue())/1000;
				int a = (int)temp;
				p3.setBounds(15,a,1136,p3.getHeight());
				sb1.setValue(sb2.getValue());
			}
		});
		
		p3.addMouseWheelListener(new MouseWheelListener(){
			public void mouseWheelMoved(MouseWheelEvent e){
				int notches = e.getWheelRotation();
				if(notches<0){
					if(p3.getY()<0){ p3.setBounds(15,p3.getY()+100,1136,p3.getHeight()); }
				}else{
					if(p3.getY()>(400-p3.getHeight())){ p3.setBounds(15,p3.getY()-100,1136,p3.getHeight()); }
				}
				long setbarvalue = ((long)p3.getY()*1000)/(long)(401-p3.getHeight());
				sb1.setValue((int)setbarvalue);
				sb2.setValue((int)setbarvalue);
			}
		});
		
		SetPreviousTimeTableData();
		
	}
	
	public void SetPreviousTimeTableData(){
		
		// PTTcount = 10;
		
		if(PTTcount == 0){
			
			l10.setVisible(true);
			
		}else{
			
			l10.setVisible(false);
			
			int i;
			for(i=0;i<PTTcount;i++){
				
				JPanel tempJPanel = new JPanel();
				tempJPanel.setBackground(new Color(153,204,255));
				tempJPanel.setBounds(20,20+(i*95),1096,75);
				tempJPanel.setBorder(new LineBorder(Color.red,2));
				tempJPanel.setLayout(null);
				PTT.add(tempJPanel);
				p3.add(PTT.get(PTT.size()-1));
				
				JLabel tempJLabel1 = new JLabel(Integer.toString(i));
				tempJLabel1.setFont(new Font("TimesRoman",Font.BOLD,30));
				tempJLabel1.setBounds(20,20,525,35);
				tempJLabel1.setForeground(new Color(0,0,255));
				PTTname.add(tempJLabel1);
				PTT.get(i).add(PTTname.get(PTTname.size()-1));
				
				String dateString = dateFormat.format(new Date()).toString();
				
				JLabel tempJLabel2 = new JLabel(dateString);
				tempJLabel2.setFont(new Font("TimesRoman",Font.BOLD,20));
				tempJLabel2.setBounds(575,20,175,35);
				tempJLabel2.setForeground(new Color(0,0,255));
				PTTdate.add(tempJLabel2);
				PTT.get(i).add(PTTdate.get(PTTdate.size()-1));
				
				JButton tempJButton1 = new JButton(i8);
				tempJButton1.setBounds(766,5,i8.getIconWidth(),i8.getIconHeight());
				tempJButton1.setOpaque(false);
				tempJButton1.setContentAreaFilled(false);
				tempJButton1.setBorderPainted(false);
				tempJButton1.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
				tempJButton1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae){
						confirmfBy = "delete";
						confirmf.setVisible(true);
						f.setEnabled(false);
					}
				});
				PTTdeleteKey.add(tempJButton1);
				PTT.get(i).add(PTTdeleteKey.get(PTTdeleteKey.size()-1));
				
				JButton tempJButton2 = new JButton(i9);
				tempJButton2.setBounds(871,5,i9.getIconWidth(),i9.getIconHeight());
				tempJButton2.setOpaque(false);
				tempJButton2.setContentAreaFilled(false);
				tempJButton2.setBorderPainted(false);
				tempJButton2.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
				tempJButton2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae){
						confirmfBy = "edit";
						confirmf.setVisible(true);
						f.setEnabled(false);
					}
				});
				PTTeditKey.add(tempJButton2);
				PTT.get(i).add(PTTeditKey.get(PTTeditKey.size()-1));
				
				JButton tempJButton3 = new JButton(i10);
				tempJButton3.setBounds(976,5,i10.getIconWidth(),i10.getIconHeight());
				tempJButton3.setOpaque(false);
				tempJButton3.setContentAreaFilled(false);
				tempJButton3.setBorderPainted(false);
				tempJButton3.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
				tempJButton3.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae){
						
					}
				});
				PTTshowKey.add(tempJButton3);
				PTT.get(i).add(PTTshowKey.get(PTTshowKey.size()-1));
				
			}
			p3.setBounds(15,p3.getY(),1136,20+(i*95));
		
		}
		
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	public void EditPage(){
		
		p4 = new JPanel();
		p4.setBounds(0,0,1366,768);
		p4.setBorder(new LineBorder(Color.black,1));
		p4.setLayout(null);
		p4.setVisible(false);
		f.add(p4);
		
		i11 = new ImageIcon("IconsTimeTable\\step1_key.png");
		i11 = new ImageIcon(i11.getImage().getScaledInstance(100,100,java.awt.Image.SCALE_SMOOTH));
		b3 = new JButton(i11);
		b3.setBounds(60,131,i11.getIconWidth(),i11.getIconHeight());
		b3.setOpaque(false);
		b3.setContentAreaFilled(false);
		b3.setBorderPainted(false);
		b3.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				SortFirstEditPage();
				SetEditPanelValue(0);
			}
		});
		p4.add(b3);
		
		i12 = new ImageIcon("IconsTimeTable\\step2_key.png");
		i12 = new ImageIcon(i12.getImage().getScaledInstance(100,100,java.awt.Image.SCALE_SMOOTH));
		b4 = new JButton(i12);
		b4.setBounds(10,303,i12.getIconWidth(),i12.getIconHeight());
		b4.setOpaque(false);
		b4.setContentAreaFilled(false);
		b4.setBorderPainted(false);
		b4.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				SortFirstEditPage();
				ShiftEditPanelElements(1);
			}
		});
		p4.add(b4);
		
		i13 = new ImageIcon("IconsTimeTable\\step3_key.png");
		i13 = new ImageIcon(i13.getImage().getScaledInstance(100,100,java.awt.Image.SCALE_SMOOTH));
		b5 = new JButton(i13);
		b5.setBounds(10,475,i13.getIconWidth(),i13.getIconHeight());
		b5.setOpaque(false);
		b5.setContentAreaFilled(false);
		b5.setBorderPainted(false);
		b5.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				SortFirstEditPage();
				ShiftEditPanelElements(2);
			}
		});
		p4.add(b5);
		
		i14 = new ImageIcon("IconsTimeTable\\home_key.png");
		i14 = new ImageIcon(i14.getImage().getScaledInstance(150,150,java.awt.Image.SCALE_SMOOTH));
		b6 = new JButton(i14);
		b6.setBounds(1206,106,i14.getIconWidth(),i14.getIconHeight());
		b6.setOpaque(false);
		b6.setContentAreaFilled(false);
		b6.setBorderPainted(false);
		b6.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
		b6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				confirmfBy = "home";
				confirmf.setVisible(true);
				f.setEnabled(false);
			}
		});
		p4.add(b6);
		
		i15 = new ImageIcon("IconsTimeTable\\save_key.png");
		i15 = new ImageIcon(i15.getImage().getScaledInstance(150,150,java.awt.Image.SCALE_SMOOTH));
		b7 = new JButton(i15);
		b7.setBounds(1206,278,i15.getIconWidth(),i15.getIconHeight());
		b7.setOpaque(false);
		b7.setContentAreaFilled(false);
		b7.setBorderPainted(false);
		b7.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
		b7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				//l8.setText("Successfully Saved !");
				//l8.setFont(new Font("TimesRoman",Font.BOLD,60));
				//informf.setVisible(true);
				//f.setEnabled(false);
			}
		});
		p4.add(b7);
		
		i16 = new ImageIcon("IconsTimeTable\\next_key.png");
		i16 = new ImageIcon(i16.getImage().getScaledInstance(150,150,java.awt.Image.SCALE_SMOOTH));
		b8 = new JButton(i16);
		b8.setBounds(1206,450,i16.getIconWidth(),i16.getIconHeight());
		b8.setOpaque(false);
		b8.setContentAreaFilled(false);
		b8.setBorderPainted(false);
		b8.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
		b8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(ep[0].isVisible()){
					SortFirstEditPage();
					ShiftEditPanelElements(1);
				}else if(ep[1].isVisible()){
					ShiftEditPanelElements(2);
				}else if(ep[2].isVisible()){
					
					boolean isEmpty = false;
					for(int i=0;i<classInput.size();i++){
						for(int j=0;j<divisionInput.get(i).size();j++){
							if(!(subjectChoose.get(i).get(j).size()==1 && subjectChoose.get(i).get(j).get(0).getSelectedItem().equals("Select Subject For Lecture") && subjectTeacherChoose.get(i).get(j).get(0).size()==1 && subjectTeacherChoose.get(i).get(j).get(0).get(0).getSelectedItem().equals("Select Teacher For Lecture"))){
								for(int k=0;k<subjectChoose.get(i).get(j).size();k++){
									for(int l=0;l<subjectTeacherChoose.get(i).get(j).get(k).size();l++){
										if(subjectTeacherChoose.get(i).get(j).get(k).get(l).getSelectedItem().equals("Select Teacher For Lecture")){
											isEmpty = true;
											break;
										}
									}
									if(isEmpty){ break; }
									if(subjectChoose.get(i).get(j).get(k).getSelectedItem().equals("Select Subject For Lecture")){
										isEmpty = true;
										break;
									}
								}
								if(isEmpty){ break; }
							}
							
							if(!(batchInput.get(i).get(j).size()==1 && batchInput.get(i).get(j).get(0).getText().equals("Enter Batch Name") && practicalSubjectChoose.get(i).get(j).get(0).size()==1 && practicalSubjectChoose.get(i).get(j).get(0).get(0).getSelectedItem().equals("Select Subject For Practical") && practicalSubjectTeacherChoose.get(i).get(j).get(0).get(0).size()==1 && practicalSubjectTeacherChoose.get(i).get(j).get(0).get(0).get(0).getSelectedItem().equals("Select Teacher For Practical"))){
								for(int k=0;k<batchInput.get(i).get(j).size();k++){
									for(int l=0;l<practicalSubjectChoose.get(i).get(j).get(k).size();l++){
										for(int m=0;m<practicalSubjectTeacherChoose.get(i).get(j).get(k).get(l).size();m++){
											if(practicalSubjectTeacherChoose.get(i).get(j).get(k).get(l).get(m).getSelectedItem().equals("Select Teacher For Practical")){
												isEmpty = true;
												break;
											}
										}
										if(isEmpty){ break; }
										if(practicalSubjectChoose.get(i).get(j).get(k).get(l).getSelectedItem().equals("Select Subject For Practical")){
											isEmpty = true;
											break;
										}
									}
									if(isEmpty){ break; }
									if(batchInput.get(i).get(j).get(k).getText().equals("Enter Batch Name")){
										isEmpty = true;
										break;
									}
								}
								if(isEmpty){ break; }
							}
							
							if(divisionInput.get(i).get(j).getText().equals("Enter Division Name")){
								isEmpty = true;
								break;
							}
						}
						if(isEmpty){ break; }
						if(classInput.get(i).getText().equals("Enter Class Name")){
							isEmpty = true;
							break;
						}
					}
					
					if(isEmpty){
						l8.setText("Please Fill All Empty Space !");
						l8.setFont(new Font("TimesRoman",Font.BOLD,40));
						informf.setVisible(true);
						f.setEnabled(false);
					}else{
						PutTT();
						p4.setVisible(false);
						TTMainPanel.setVisible(true);
					}
				}
			}
		});
		p4.add(b8);
		
		p5 = new JPanel();
		p5.setBounds(176,26,1004,654);
		p5.setLayout(null);
		p4.add(p5);
		
		ep = new JPanel[3];
		
		for(int i=0;i<3;i++){
			
			ep[i] = new JPanel();
			if(i==0) { ep[i].setBounds(0,0,1004,654); }
			else if(i==1) { ep[i].setBounds(0,0,3315,654); }
			else if(i==2) { ep[i].setBounds(0,0,4085,654); }
			ep[i].setBackground(new Color(153,255,255));
			ep[i].setVisible(false);
			ep[i].setLayout(null);
			p5.add(ep[i]);
			
		}
		
		for(int i=0;i<3;i++){
			
			if(i==0){
				ep[0].setVisible(true);
			}else if(i==1){
				ep[0].setVisible(false);
				ep[1].setVisible(true);
			}else if(i==2){
				ep[1].setVisible(false);
				ep[2].setVisible(true);
			}
			
			ep[i].addMouseMotionListener(new MouseMotionListener(){
				public void mouseDragged(MouseEvent e){
					ScrollByDrag("Dragged",e);
				}
				public void mouseMoved(MouseEvent e){
					ScrollByDrag("Moved",e);
				}
				public void ScrollByDrag(String action,MouseEvent e){
					if(action.equals("Moved")){
						dragX = e.getX();
						dragY = e.getY();
					}else if(action.equals("Dragged")){
						for(int i=0;i<3;i++){
							if(ep[i].isVisible() == true){
								if(ep[i].getX()+(e.getX()-dragX)<=0&&-(ep[i].getX()+(e.getX()-dragX))<=ep[i].getWidth()-1004){
									ep[i].setBounds(ep[i].getX()+(e.getX()-dragX),ep[i].getY(),ep[i].getWidth(),ep[i].getHeight());
									SetEditPanelValue(i);
								}
								if(ep[i].getY()+(e.getY()-dragY)<=0&&-(ep[i].getY()+(e.getY()-dragY))<=ep[i].getHeight()-654){
									ep[i].setBounds(ep[i].getX(),ep[i].getY()+(e.getY()-dragY),ep[i].getWidth(),ep[i].getHeight());
									SetEditPanelValue(i);
								}
							}
						}
					}
				}
			});
			
			ep[i].addMouseWheelListener(new MouseWheelListener(){
				public void mouseWheelMoved(MouseWheelEvent e){
					for(int i=0;i<3;i++){
						if(ep[i].isVisible() == true){
							int notches = e.getWheelRotation();
							if(notches<0){
								if(ep[i].getY()<0){ ep[i].setBounds(ep[i].getX(),ep[i].getY()+100,ep[i].getWidth(),ep[i].getHeight()); }
							}else{
								if(ep[i].getY()>(654-ep[i].getHeight())){ ep[i].setBounds(ep[i].getX(),ep[i].getY()-100,ep[i].getWidth(),ep[i].getHeight()); }
							}
							SetEditPanelValue(i);
						}
					}
				}
			});
		}
		
		ep[0].setVisible(true);
		ep[1].setVisible(false);
		ep[2].setVisible(false);
		
		sb3 = new JScrollBar(JScrollBar.VERTICAL,1,100,0,1100);
		sb3.setBounds(1180,26,16,670);
		sb3.setBackground(new Color(255,153,153));
		p4.add(sb3);
		
		sb4 = new JScrollBar(JScrollBar.HORIZONTAL,1,100,0,1100);
		sb4.setBounds(160,680,1020,16);
		sb4.setBackground(new Color(255,153,153));
		p4.add(sb4);
		
		sb3.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent e) {
				for(int i=0;i<3;i++){
					if(ep[i].isVisible() == true){
						long temp = ((long)(654-ep[i].getHeight())*(long)sb3.getValue())/1000;
						int a = (int)temp;
						ep[i].setBounds(ep[i].getX(),a,ep[i].getWidth(),ep[i].getHeight());
					}
				}
				sb5.setValue(sb3.getValue());
			}
		});
		
		sb4.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent e) {
				for(int i=0;i<3;i++){
					if(ep[i].isVisible() == true){
						long temp = ((long)(1004-ep[i].getWidth())*(long)sb4.getValue())/1000;
						int a = (int)temp;
						ep[i].setBounds(a,ep[i].getY(),ep[i].getWidth(),ep[i].getHeight());
					}
				}
				sb6.setValue(sb4.getValue());
			}
		});
		
		sb5 = new JScrollBar(JScrollBar.VERTICAL,1,100,0,1100);
		sb5.setBounds(160,10,16,670);
		sb5.setBackground(new Color(255,153,153));
		p4.add(sb5);
		
		sb6 = new JScrollBar(JScrollBar.HORIZONTAL,1,100,0,1100);
		sb6.setBounds(176,10,1020,16);
		sb6.setBackground(new Color(255,153,153));
		p4.add(sb6);
		
		sb5.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent e) {
				for(int i=0;i<3;i++){
					if(ep[i].isVisible() == true){
						long temp = ((long)(654-ep[i].getHeight())*(long)sb5.getValue())/1000;
						int a = (int)temp;
						ep[i].setBounds(ep[i].getX(),a,ep[i].getWidth(),ep[i].getHeight());
					}
				}
				sb3.setValue(sb5.getValue());
			}
		});
		
		sb6.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent e) {
				for(int i=0;i<3;i++){
					if(ep[i].isVisible() == true){
						long temp = ((long)(1004-ep[i].getWidth())*(long)sb6.getValue())/1000;
						int a = (int)temp;
						ep[i].setBounds(a,ep[i].getY(),ep[i].getWidth(),ep[i].getHeight());
					}
				}
				sb4.setValue(sb6.getValue());
			}
		});
		
		l5 = new JLabel(i5);
		l5.setBounds(0,0,1366,768);
		p4.add(l5);
		
		FirstEditPage();
		SecondEditPage();
		
	}
	
	public void SetEditPanelValue(int panel){
		
		if(panel==0){
			b3.setBounds(60,131,i11.getIconWidth(),i11.getIconHeight());
			b4.setBounds(10,303,i11.getIconWidth(),i11.getIconHeight());
			b5.setBounds(10,475,i11.getIconWidth(),i11.getIconHeight());
		} else if(panel==1){
			b3.setBounds(10,131,i11.getIconWidth(),i11.getIconHeight());
			b4.setBounds(60,303,i11.getIconWidth(),i11.getIconHeight());
			b5.setBounds(10,475,i11.getIconWidth(),i11.getIconHeight());
		} else if(panel==2){
			b3.setBounds(10,131,i11.getIconWidth(),i11.getIconHeight());
			b4.setBounds(10,303,i11.getIconWidth(),i11.getIconHeight());
			b5.setBounds(60,475,i11.getIconWidth(),i11.getIconHeight());
		}
		
		ep[panel].setVisible(true);
		for(int i=0;i<3;i++){
			if(panel!=i){ ep[i].setVisible(false); }
		}
		
		long setbarvalue = ((long)ep[panel].getY()*1000)/(long)(655-ep[panel].getHeight());
		sb3.setValue((int)setbarvalue);
		sb5.setValue((int)setbarvalue);
		setbarvalue = ((long)ep[panel].getX()*1000)/(long)(1005-ep[panel].getWidth());
		sb4.setValue((int)setbarvalue);
		sb6.setValue((int)setbarvalue);
		
		ep[panel].setBounds(ep[panel].getX(),ep[panel].getY()+1,ep[panel].getWidth(),ep[panel].getHeight());
		ep[panel].setBounds(ep[panel].getX(),ep[panel].getY()-1,ep[panel].getWidth(),ep[panel].getHeight());
		
		ForFirstFocusOnly.requestFocus();
		
	}
	
	public void ShiftEditPanelElements(int panel){
		
		if(panel==1){
			
			for(int i=0;i<classInputPanel.size();i++){
				ep[1].add(classInputPanel.get(i));
			}
			for(int i=0;i<classInputPanel.size();i++){
				for(int j=0;j<divisionInputPanel.get(i).size();j++){
					for(int k=0;k<batchInputPanel.get(i).get(j).size();k++){
						batchInputPanel.get(i).get(j).get(k).setVisible(false);
					}
				}
			}
			for(int i=0;i<classInputPanel.size();i++){
				for(int j=0;j<divisionInputPanel.get(i).size();j++){
					for(int k=0;k<subjectChoosePanel.get(i).get(j).size();k++){
						subjectChoosePanel.get(i).get(j).get(k).setVisible(true);
					}
				}
			}
			
			RearrangeSecondEditPage();
			
		}else if(panel==2){
			
			for(int i=0;i<classInputPanel.size();i++){
				ep[2].add(classInputPanel.get(i));
			}
			for(int i=0;i<classInputPanel.size();i++){
				for(int j=0;j<divisionInputPanel.get(i).size();j++){
					for(int k=0;k<subjectChoosePanel.get(i).get(j).size();k++){
						subjectChoosePanel.get(i).get(j).get(k).setVisible(false);
					}
				}
			}
			for(int i=0;i<classInputPanel.size();i++){
				for(int j=0;j<divisionInputPanel.get(i).size();j++){
					for(int k=0;k<batchInputPanel.get(i).get(j).size();k++){
						batchInputPanel.get(i).get(j).get(k).setVisible(true);
					}
				}
			}
			
			RearrangeThirdEditPage();
			
		}
		
	}
	
	                  //***********************************************//
	
	public void FirstEditPage(){
		
		title = new JTextField("Enter Title Of TimeTable");
		title.setOpaque(false);
		title.setForeground(new Color(102,178,225));
		title.setCaretColor(new Color(0,0,255));
		title.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.blue));
		title.setFont(new Font("TimesRoman",Font.BOLD+Font.ITALIC,65));
		title.setHorizontalAlignment(JTextField.CENTER);
		title.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e){
				if(title.getText().equals("Enter Title Of TimeTable")){
					title.setText("");
					title.setForeground(new Color(0,128,255));
					title.setFont(new Font("TimesRoman",Font.BOLD,65));
				}
			}
			public void focusLost(FocusEvent e){
				if(title.getText().equals("")){
					title.setText("Enter Title Of TimeTable");
					title.setForeground(new Color(102,178,225));
					title.setFont(new Font("TimesRoman",Font.BOLD+Font.ITALIC,65));
				}
			}
		});
		ep[0].add(title);
		
		i21 = new ImageIcon("IconsTimeTable\\cross1.png");
		i21 = new ImageIcon(i21.getImage().getScaledInstance(35,35,java.awt.Image.SCALE_SMOOTH));
		
		removeTeacher = new JButton("Remove Teacher");
		removeTeacher.setFont(new Font("TimesRoman",Font.BOLD,25));
		removeTeacher.setForeground(new Color(255,102,102));
		removeTeacher.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				int decrement = Integer.parseInt(addTeacherCount.getText());
				if(teacherNameInput.size()-decrement<0){ decrement = teacherNameInput.size(); }
				for(int i=0;i<decrement;i++){
					ep[0].remove(teacherNameInput.get(teacherNameInput.size()-1));
					ep[0].remove(teacherNameCross.get(teacherNameCross.size()-1));
					teacherNameInput.remove(teacherNameInput.size()-1);
					teacherNameCross.remove(teacherNameCross.size()-1);
				}
				RearrangeFirstEditPage();
				addTeacherCount.setText("1");
			}
		});
		ep[0].add(removeTeacher);
		
		addTeacherCount = new JTextField("1");
		addTeacherCount.setBackground(new Color(192,255,255));
		addTeacherCount.setForeground(new Color(0,128,255));
		addTeacherCount.setFont(new Font("TimesRoman",Font.BOLD,25));
		addTeacherCount.setHorizontalAlignment(JTextField.CENTER);
		addTeacherCount.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e){
				if(addTeacherCount.getText().equals("1")){
					addTeacherCount.setText("");
				}
			}
			public void focusLost(FocusEvent e){
				if(addTeacherCount.getText().equals("")){
					addTeacherCount.setText("1");
				}
			}
		});
		addTeacherCount.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent e){
				char c = e.getKeyChar();
				if(!Character.isDigit(c)&&e.getExtendedKeyCode()!=KeyEvent.VK_BACK_SPACE&&e.getExtendedKeyCode()!=KeyEvent.VK_DELETE) addTeacherCount.setEditable(false);
				else if(addTeacherCount.getText().length()>=3&&e.getExtendedKeyCode()!=KeyEvent.VK_BACK_SPACE&&e.getExtendedKeyCode()!=KeyEvent.VK_DELETE) addTeacherCount.setEditable(false);
			}
			public void keyTyped(KeyEvent e){}
			public void keyReleased(KeyEvent e){
				addTeacherCount.setEditable(true);
			}
		});
		ep[0].add(addTeacherCount);
		
		addTeacher = new JButton("Add Teacher");
		addTeacher.setFont(new Font("TimesRoman",Font.BOLD,25));
		addTeacher.setForeground(new Color(255,102,102));
		addTeacher.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				TeacherAddFunction();
			}
		});
		ep[0].add(addTeacher);
		
		subjectDefaultLabel[0] = new JLabel("Time Per Lecture (Minutes)   : ");
		subjectDefaultLabel[1] = new JLabel("Lecture Per Week (Count)      : ");
		subjectDefaultLabel[2] = new JLabel("Time Per Practical (Minutes) : ");
		subjectDefaultLabel[3] = new JLabel("Practical Per Week (Count)    : ");
		
		subjectDefaultText[0] = new JTextField("60");
		subjectDefaultText[1] = new JTextField("3");
		subjectDefaultText[2] = new JTextField("120");
		subjectDefaultText[3] = new JTextField("1");
		
		for(int i=0;i<4;i++){
			
			subjectDefaultLabel[i].setFont(new Font("TimesRoman",Font.BOLD,25));
			subjectDefaultLabel[i].setForeground(new Color(255,102,102));
			ep[0].add(subjectDefaultLabel[i]);
			
			subjectDefaultText[i].setBackground(new Color(192,255,255));
			subjectDefaultText[i].setForeground(new Color(0,128,255));
			subjectDefaultText[i].setFont(new Font("TimesRoman",Font.BOLD,25));
			subjectDefaultText[i].setHorizontalAlignment(JTextField.CENTER);
			subjectDefaultText[i].addFocusListener(new FocusListener(){
				public void focusGained(FocusEvent e){
					for(int i=0;i<4;i++){
						if(subjectDefaultText[i].isFocusOwner()){
							if(subjectDefaultText[i].getText().equals("60")&&i==0){
								subjectDefaultText[i].setText("");
							}else if(subjectDefaultText[i].getText().equals("3")&&i==1){
								subjectDefaultText[i].setText("");
							}else if(subjectDefaultText[i].getText().equals("120")&&i==2){
								subjectDefaultText[i].setText("");
							}else if(subjectDefaultText[i].getText().equals("1")&&i==3){
								subjectDefaultText[i].setText("");
							}
							lastFocused = i;
						}
					}
				}
				public void focusLost(FocusEvent e){
					int i = lastFocused;
					if(subjectDefaultText[i].getText().equals("")&&i==0){
						subjectDefaultText[i].setText("60");
					}else if(subjectDefaultText[i].getText().equals("")&&i==1){
						subjectDefaultText[i].setText("3");
					}else if(subjectDefaultText[i].getText().equals("")&&i==2){
						subjectDefaultText[i].setText("120");
					}else if(subjectDefaultText[i].getText().equals("")&&i==3){
						subjectDefaultText[i].setText("1");
					}
				}
			});
			subjectDefaultText[i].addKeyListener(new KeyListener(){
				public void keyPressed(KeyEvent e){
					for(int i=0;i<4;i++){
						if(subjectDefaultText[i].isFocusOwner()){
							char c = e.getKeyChar();
							if(!Character.isDigit(c)&&e.getExtendedKeyCode()!=KeyEvent.VK_BACK_SPACE&&e.getExtendedKeyCode()!=KeyEvent.VK_DELETE) subjectDefaultText[i].setEditable(false);
							else if(subjectDefaultText[i].getText().length()>=3&&e.getExtendedKeyCode()!=KeyEvent.VK_BACK_SPACE&&e.getExtendedKeyCode()!=KeyEvent.VK_DELETE) subjectDefaultText[i].setEditable(false);
							lastFocused = i;
						}
					}
				}
				public void keyTyped(KeyEvent e){}
				public void keyReleased(KeyEvent e){
					int i = lastFocused;
					subjectDefaultText[i].setEditable(true);
				}
			});
			ep[0].add(subjectDefaultText[i]);
		}
		
		removeSubject = new JButton("Remove Subject");
		removeSubject.setFont(new Font("TimesRoman",Font.BOLD,25));
		removeSubject.setForeground(new Color(255,102,102));
		removeSubject.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				int decrement = Integer.parseInt(addSubjectCount.getText());
				if(subjectNameInput.size()-decrement<0){ decrement = subjectNameInput.size(); }
				for(int i=0;i<decrement;i++){
					ep[0].remove(subjectNameInput.get(subjectNameInput.size()-1));
					ep[0].remove(subjectNameCross.get(subjectNameCross.size()-1));
					ep[0].remove(haveLecture.get(haveLecture.size()-1));
					ep[0].remove(havePractical.get(havePractical.size()-1));
					ep[0].remove(timePerLecture.get(timePerLecture.size()-1));
					ep[0].remove(lecturePerWeek.get(lecturePerWeek.size()-1));
					ep[0].remove(timePerPractical.get(timePerPractical.size()-1));
					ep[0].remove(practicalPerWeek.get(practicalPerWeek.size()-1));
					
					subjectNameInput.remove(subjectNameInput.size()-1);
					subjectNameCross.remove(subjectNameCross.size()-1);
					haveLecture.remove(haveLecture.size()-1);
					havePractical.remove(havePractical.size()-1);
					timePerLecture.remove(timePerLecture.size()-1);
					lecturePerWeek.remove(lecturePerWeek.size()-1);
					timePerPractical.remove(timePerPractical.size()-1);
					practicalPerWeek.remove(practicalPerWeek.size()-1);
				}
				RearrangeFirstEditPage();
				addSubjectCount.setText("1");
			}
		});
		ep[0].add(removeSubject);
		
		addSubjectCount = new JTextField("1");
		addSubjectCount.setBackground(new Color(192,255,255));
		addSubjectCount.setForeground(new Color(0,128,255));
		addSubjectCount.setFont(new Font("TimesRoman",Font.BOLD,25));
		addSubjectCount.setHorizontalAlignment(JTextField.CENTER);
		addSubjectCount.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e){
				if(addSubjectCount.getText().equals("1")){
					addSubjectCount.setText("");
				}
			}
			public void focusLost(FocusEvent e){
				if(addSubjectCount.getText().equals("")){
					addSubjectCount.setText("1");
				}
			}
		});
		addSubjectCount.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent e){
				char c = e.getKeyChar();
				if(!Character.isDigit(c)&&e.getExtendedKeyCode()!=KeyEvent.VK_BACK_SPACE&&e.getExtendedKeyCode()!=KeyEvent.VK_DELETE) addSubjectCount.setEditable(false);
				else if(addSubjectCount.getText().length()>=3&&e.getExtendedKeyCode()!=KeyEvent.VK_BACK_SPACE&&e.getExtendedKeyCode()!=KeyEvent.VK_DELETE) addSubjectCount.setEditable(false);
			}
			public void keyTyped(KeyEvent e){}
			public void keyReleased(KeyEvent e){
				addSubjectCount.setEditable(true);
			}
		});
		ep[0].add(addSubjectCount);
		
		addSubject = new JButton("Add Subject");
		addSubject.setFont(new Font("TimesRoman",Font.BOLD,25));
		addSubject.setForeground(new Color(255,102,102));
		addSubject.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				SubjectAddFunction();
			}
		});
		ep[0].add(addSubject);
		
		noteShortForm = new JLabel("( *Note : Please try to use short-forms of names of teachers and subjects )");
		noteShortForm.setForeground(new Color(255,102,102));
		noteShortForm.setHorizontalAlignment(JLabel.CENTER);
		noteShortForm.setFont(new Font("TimesRoman",Font.ITALIC+Font.BOLD,25));
		ep[0].add(noteShortForm);
		
		RearrangeFirstEditPage();
		
	}
	
	public void TeacherAddFunction(){
		
		int increment = Integer.parseInt(addTeacherCount.getText());
		for(int i=0;i<increment;i++){
			
			JTextField tempJTextField = new JTextField("Enter Teacher Name");
			tempJTextField.setBackground(new Color(192,255,255));
			tempJTextField.setForeground(new Color(102,178,255));
			tempJTextField.setFont(new Font("TimesRoman",Font.BOLD+Font.ITALIC,25));
			tempJTextField.setHorizontalAlignment(JTextField.CENTER);
			tempJTextField.addFocusListener(new FocusListener(){
				public void focusGained(FocusEvent e){
					for(int i=0;i<teacherNameInput.size();i++){
						if(teacherNameInput.get(i).isFocusOwner()){
							if(teacherNameInput.get(i).getText().equals("Enter Teacher Name")){
								teacherNameInput.get(i).setText("");
								teacherNameInput.get(i).setForeground(new Color(0,128,255));
								teacherNameInput.get(i).setFont(new Font("TimesRoman",Font.BOLD,25));
							}
							lastFocused = i;
						}
					}
				}
				public void focusLost(FocusEvent e){
					int i = lastFocused;
					if(teacherNameInput.get(i).getText().equals("")){
						teacherNameInput.get(i).setText("Enter Teacher Name");
						teacherNameInput.get(i).setForeground(new Color(102,178,255));
						teacherNameInput.get(i).setFont(new Font("TimesRoman",Font.BOLD+Font.ITALIC,25));
					}
				}
			});
			teacherNameInput.add(tempJTextField);
			ep[0].add(teacherNameInput.get(teacherNameInput.size()-1));
			
			JButton tempJButton = new JButton(i21);
			tempJButton.setOpaque(false);
			tempJButton.setContentAreaFilled(false);
			tempJButton.setBorderPainted(false);
			tempJButton.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
			tempJButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					for(int i=0;i<teacherNameCross.size();i++){
						if(teacherNameCross.get(i).getModel().isArmed()){
							ep[0].remove(teacherNameInput.get(i));
							ep[0].remove(teacherNameCross.get(i));
							teacherNameInput.remove(i);
							teacherNameCross.remove(i);
							RearrangeFirstEditPage();
							break;
						}
					}
				}
			});
			teacherNameCross.add(tempJButton);
			ep[0].add(teacherNameCross.get(teacherNameCross.size()-1));
		}
		
		RearrangeFirstEditPage();
		addTeacherCount.setText("1");
		
	}
	
	public void SubjectAddFunction(){
		
		int increment = Integer.parseInt(addSubjectCount.getText());
		for(int i=0;i<increment;i++){
			
			JTextField tempJTextField1 = new JTextField("Enter Subject Name");
			tempJTextField1.setBackground(new Color(192,255,255));
			tempJTextField1.setForeground(new Color(102,178,255));
			tempJTextField1.setFont(new Font("TimesRoman",Font.BOLD+Font.ITALIC,25));
			tempJTextField1.setHorizontalAlignment(JTextField.CENTER);
			tempJTextField1.addFocusListener(new FocusListener(){
				public void focusGained(FocusEvent e){
					for(int i=0;i<subjectNameInput.size();i++){
						if(subjectNameInput.get(i).isFocusOwner()){
							if(subjectNameInput.get(i).getText().equals("Enter Subject Name")){
								subjectNameInput.get(i).setText("");
								subjectNameInput.get(i).setForeground(new Color(0,128,255));
								subjectNameInput.get(i).setFont(new Font("TimesRoman",Font.BOLD,25));
							}
							lastFocused = i;
						}
					}
				}
				public void focusLost(FocusEvent e){
					int i = lastFocused;
					if(subjectNameInput.get(i).getText().equals("")){
						subjectNameInput.get(i).setText("Enter Subject Name");
						subjectNameInput.get(i).setForeground(new Color(102,178,225));
						subjectNameInput.get(i).setFont(new Font("TimesRoman",Font.BOLD+Font.ITALIC,25));
					}
				}
			});
			subjectNameInput.add(tempJTextField1);
			ep[0].add(subjectNameInput.get(subjectNameInput.size()-1));
			
			JButton tempJButton1 = new JButton(i21);
			tempJButton1.setOpaque(false);
			tempJButton1.setContentAreaFilled(false);
			tempJButton1.setBorderPainted(false);
			tempJButton1.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
			tempJButton1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					for(int i=0;i<subjectNameCross.size();i++){
						if(subjectNameCross.get(i).getModel().isArmed()){
							ep[0].remove(subjectNameInput.get(i));
							ep[0].remove(haveLecture.get(i));
							ep[0].remove(havePractical.get(i));
							ep[0].remove(timePerLecture.get(i));
							ep[0].remove(lecturePerWeek.get(i));
							ep[0].remove(timePerPractical.get(i));
							ep[0].remove(practicalPerWeek.get(i));
							ep[0].remove(subjectNameCross.get(i));
							
							subjectNameInput.remove(i);
							haveLecture.remove(i);
							havePractical.remove(i);
							timePerLecture.remove(i);
							lecturePerWeek.remove(i);
							timePerPractical.remove(i);
							practicalPerWeek.remove(i);
							subjectNameCross.remove(i);
							RearrangeFirstEditPage();
							break;
						}
					}
				}
			});
			subjectNameCross.add(tempJButton1);
			ep[0].add(subjectNameCross.get(subjectNameCross.size()-1));
			
			JCheckBox tempJCheckBox1 = new JCheckBox("Lecture");
			tempJCheckBox1.setFont(new Font("TimesRoman",Font.BOLD,25));
			tempJCheckBox1.setForeground(new Color(255,102,102));
			tempJCheckBox1.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent e){
					for(int i=0;i<haveLecture.size();i++){
						if(haveLecture.get(i).isFocusOwner()){
							if(haveLecture.get(i).isSelected()){
								timePerLecture.get(i).setEnabled(true);
								lecturePerWeek.get(i).setEnabled(true);
								timePerLecture.get(i).setFont(new Font("TimesRoman",Font.BOLD,25));
								timePerLecture.get(i).setText(subjectDefaultText[0].getText());
								lecturePerWeek.get(i).setFont(new Font("TimesRoman",Font.BOLD,25));
								lecturePerWeek.get(i).setText(subjectDefaultText[1].getText());
							}else if(!haveLecture.get(i).isSelected()){
								timePerLecture.get(i).setFont(new Font("TimesRoman",Font.ITALIC+Font.BOLD,25));
								timePerLecture.get(i).setText("Time Per Lecture");
								lecturePerWeek.get(i).setFont(new Font("TimesRoman",Font.ITALIC+Font.BOLD,25));
								lecturePerWeek.get(i).setText("Lecture Per Week");
								timePerLecture.get(i).setEnabled(false);
								lecturePerWeek.get(i).setEnabled(false);
							}
						}
					}
				}
			});
			tempJCheckBox1.setOpaque(false);
			tempJCheckBox1.setContentAreaFilled(false);
			tempJCheckBox1.setBorderPainted(false);
			haveLecture.add(tempJCheckBox1);
			ep[0].add(haveLecture.get(haveLecture.size()-1));
			
			JTextField tempJTextField2 = new JTextField("Time Per Lecture");
			tempJTextField2.setBackground(new Color(192,255,255));
			tempJTextField2.setForeground(new Color(0,128,255));
			tempJTextField2.setFont(new Font("TimesRoman",Font.ITALIC+Font.BOLD,25));
			tempJTextField2.setHorizontalAlignment(JTextField.CENTER);
			tempJTextField2.addFocusListener(new FocusListener(){
				public void focusGained(FocusEvent e){
					for(int i=0;i<timePerLecture.size();i++){
						if(timePerLecture.get(i).isFocusOwner()){
							if(timePerLecture.get(i).getText().equals(subjectDefaultText[0].getText())){
								timePerLecture.get(i).setText("");
							}
							lastFocused = i;
						}
					}
				}
				public void focusLost(FocusEvent e){
					int i = lastFocused;
					if(timePerLecture.get(i).getText().equals("")){
						timePerLecture.get(i).setText(subjectDefaultText[0].getText());
					}
				}
			});
			tempJTextField2.addKeyListener(new KeyListener(){
				public void keyPressed(KeyEvent e){
					for(int i=0;i<timePerLecture.size();i++){
						if(timePerLecture.get(i).isFocusOwner()){
							char c = e.getKeyChar();
							if(!Character.isDigit(c)&&e.getExtendedKeyCode()!=KeyEvent.VK_BACK_SPACE&&e.getExtendedKeyCode()!=KeyEvent.VK_DELETE) timePerLecture.get(i).setEditable(false);
							else if(timePerLecture.get(i).getText().length()>=3&&e.getExtendedKeyCode()!=KeyEvent.VK_BACK_SPACE&&e.getExtendedKeyCode()!=KeyEvent.VK_DELETE) timePerLecture.get(i).setEditable(false);
							lastFocused = i;
						}
					}
				}
				public void keyTyped(KeyEvent e){}
				public void keyReleased(KeyEvent e){
					int i = lastFocused;
					timePerLecture.get(i).setEditable(true);
				}
			});
			tempJTextField2.setEnabled(false);
			timePerLecture.add(tempJTextField2);
			ep[0].add(timePerLecture.get(timePerLecture.size()-1));
			
			JTextField tempJTextField3 = new JTextField("Lecture Per Week");
			tempJTextField3.setBackground(new Color(192,255,255));
			tempJTextField3.setForeground(new Color(0,128,255));
			tempJTextField3.setFont(new Font("TimesRoman",Font.ITALIC+Font.BOLD,25));
			tempJTextField3.setHorizontalAlignment(JTextField.CENTER);
			tempJTextField3.addFocusListener(new FocusListener(){
				public void focusGained(FocusEvent e){
					for(int i=0;i<lecturePerWeek.size();i++){
						if(lecturePerWeek.get(i).isFocusOwner()){
							if(lecturePerWeek.get(i).getText().equals(subjectDefaultText[1].getText())){
								lecturePerWeek.get(i).setText("");
							}
							lastFocused = i;
						}
					}
				}
				public void focusLost(FocusEvent e){
					int i = lastFocused;
					if(lecturePerWeek.get(i).getText().equals("")){
						lecturePerWeek.get(i).setText(subjectDefaultText[1].getText());
					}
				}
			});
			tempJTextField3.addKeyListener(new KeyListener(){
				public void keyPressed(KeyEvent e){
					for(int i=0;i<lecturePerWeek.size();i++){
						if(lecturePerWeek.get(i).isFocusOwner()){
							char c = e.getKeyChar();
							if(!Character.isDigit(c)&&e.getExtendedKeyCode()!=KeyEvent.VK_BACK_SPACE&&e.getExtendedKeyCode()!=KeyEvent.VK_DELETE) lecturePerWeek.get(i).setEditable(false);
							else if(lecturePerWeek.get(i).getText().length()>=3&&e.getExtendedKeyCode()!=KeyEvent.VK_BACK_SPACE&&e.getExtendedKeyCode()!=KeyEvent.VK_DELETE) lecturePerWeek.get(i).setEditable(false);
							lastFocused = i;
						}
					}
				}
				public void keyTyped(KeyEvent e){}
				public void keyReleased(KeyEvent e){
					int i = lastFocused;
					lecturePerWeek.get(i).setEditable(true);
				}
			});
			tempJTextField3.setEnabled(false);
			lecturePerWeek.add(tempJTextField3);
			ep[0].add(lecturePerWeek.get(lecturePerWeek.size()-1));
			
			JCheckBox tempJCheckBox2 = new JCheckBox("Practical");
			tempJCheckBox2.setFont(new Font("TimesRoman",Font.BOLD,25));
			tempJCheckBox2.setForeground(new Color(255,102,102));
			tempJCheckBox2.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent e){
					for(int i=0;i<havePractical.size();i++){
						if(havePractical.get(i).isFocusOwner()){
							if(havePractical.get(i).isSelected()){
								timePerPractical.get(i).setEnabled(true);
								practicalPerWeek.get(i).setEnabled(true);
								timePerPractical.get(i).setFont(new Font("TimesRoman",Font.BOLD,25));
								timePerPractical.get(i).setText(subjectDefaultText[2].getText());
								practicalPerWeek.get(i).setFont(new Font("TimesRoman",Font.BOLD,25));
								practicalPerWeek.get(i).setText(subjectDefaultText[3].getText());
							}else if(!havePractical.get(i).isSelected()){
								timePerPractical.get(i).setFont(new Font("TimesRoman",Font.ITALIC+Font.BOLD,25));
								timePerPractical.get(i).setText("Time Per Practical");
								practicalPerWeek.get(i).setFont(new Font("TimesRoman",Font.ITALIC+Font.BOLD,25));
								practicalPerWeek.get(i).setText("Practical Per Week");
								timePerPractical.get(i).setEnabled(false);
								practicalPerWeek.get(i).setEnabled(false);
							}
						}
					}
				}
			});
			tempJCheckBox2.setOpaque(false);
			tempJCheckBox2.setContentAreaFilled(false);
			tempJCheckBox2.setBorderPainted(false);
			havePractical.add(tempJCheckBox2);
			ep[0].add(havePractical.get(havePractical.size()-1));
			
			JTextField tempJTextField4 = new JTextField("Time Per Practical");
			tempJTextField4.setBackground(new Color(192,255,255));
			tempJTextField4.setForeground(new Color(0,128,255));
			tempJTextField4.setFont(new Font("TimesRoman",Font.ITALIC+Font.BOLD,25));
			tempJTextField4.setHorizontalAlignment(JTextField.CENTER);
			tempJTextField4.addFocusListener(new FocusListener(){
				public void focusGained(FocusEvent e){
					for(int i=0;i<timePerPractical.size();i++){
						if(timePerPractical.get(i).isFocusOwner()){
							if(timePerPractical.get(i).getText().equals(subjectDefaultText[2].getText())){
								timePerPractical.get(i).setText("");
							}
							lastFocused = i;
						}
					}
				}
				public void focusLost(FocusEvent e){
					int i = lastFocused;
					if(timePerPractical.get(i).getText().equals("")){
						timePerPractical.get(i).setText(subjectDefaultText[2].getText());
					}
				}
			});
			tempJTextField4.addKeyListener(new KeyListener(){
				public void keyPressed(KeyEvent e){
					for(int i=0;i<timePerPractical.size();i++){
						if(timePerPractical.get(i).isFocusOwner()){
							char c = e.getKeyChar();
							if(!Character.isDigit(c)&&e.getExtendedKeyCode()!=KeyEvent.VK_BACK_SPACE&&e.getExtendedKeyCode()!=KeyEvent.VK_DELETE) timePerPractical.get(i).setEditable(false);
							else if(timePerPractical.get(i).getText().length()>=3&&e.getExtendedKeyCode()!=KeyEvent.VK_BACK_SPACE&&e.getExtendedKeyCode()!=KeyEvent.VK_DELETE) timePerPractical.get(i).setEditable(false);
							lastFocused = i;
						}
					}
				}
				public void keyTyped(KeyEvent e){}
				public void keyReleased(KeyEvent e){
					int i = lastFocused;
					timePerPractical.get(i).setEditable(true);
				}
			});
			tempJTextField4.setEnabled(false);
			timePerPractical.add(tempJTextField4);
			ep[0].add(timePerPractical.get(timePerPractical.size()-1));
			
			JTextField tempJTextField5 = new JTextField("Practical Per Week");
			tempJTextField5.setBackground(new Color(192,255,255));
			tempJTextField5.setForeground(new Color(0,128,255));
			tempJTextField5.setFont(new Font("TimesRoman",Font.ITALIC+Font.BOLD,25));
			tempJTextField5.setHorizontalAlignment(JTextField.CENTER);
			tempJTextField5.addFocusListener(new FocusListener(){
				public void focusGained(FocusEvent e){
					for(int i=0;i<practicalPerWeek.size();i++){
						if(practicalPerWeek.get(i).isFocusOwner()){
							if(practicalPerWeek.get(i).getText().equals(subjectDefaultText[3].getText())){
								practicalPerWeek.get(i).setText("");
							}
							lastFocused = i;
						}
					}
				}
				public void focusLost(FocusEvent e){
					int i = lastFocused;
					if(practicalPerWeek.get(i).getText().equals("")){
						practicalPerWeek.get(i).setText(subjectDefaultText[3].getText());
					}
				}
			});
			tempJTextField5.addKeyListener(new KeyListener(){
				public void keyPressed(KeyEvent e){
					for(int i=0;i<practicalPerWeek.size();i++){
						if(practicalPerWeek.get(i).isFocusOwner()){
							char c = e.getKeyChar();
							if(!Character.isDigit(c)&&e.getExtendedKeyCode()!=KeyEvent.VK_BACK_SPACE&&e.getExtendedKeyCode()!=KeyEvent.VK_DELETE) practicalPerWeek.get(i).setEditable(false);
							else if(practicalPerWeek.get(i).getText().length()>=3&&e.getExtendedKeyCode()!=KeyEvent.VK_BACK_SPACE&&e.getExtendedKeyCode()!=KeyEvent.VK_DELETE) practicalPerWeek.get(i).setEditable(false);
							lastFocused = i;
						}
					}
				}
				public void keyTyped(KeyEvent e){}
				public void keyReleased(KeyEvent e){
					int i = lastFocused;
					practicalPerWeek.get(i).setEditable(true);
				}
			});
			tempJTextField5.setEnabled(false);
			practicalPerWeek.add(tempJTextField5);
			ep[0].add(practicalPerWeek.get(practicalPerWeek.size()-1));
			
		}
		
		RearrangeFirstEditPage();
		addSubjectCount.setText("1");
		
	}
	
	public void RearrangeFirstEditPage(){
		
		int Y;
		
		title.setBounds(12,100,980,100);
		
		for(int i=0;i<teacherNameInput.size();i++){
			if(i%2==0){
				teacherNameInput.get(i).setBounds(50,250+((i/2)*50),395,35);
				teacherNameCross.get(i).setBounds(450,250+((i/2)*50),i21.getIconWidth(),i21.getIconHeight());
			}else{
				teacherNameInput.get(i).setBounds(519,250+((i/2)*50),395,35);
				teacherNameCross.get(i).setBounds(919,250+((i/2)*50),i21.getIconWidth(),i21.getIconHeight());
			}
		}
		
		if(teacherNameInput.isEmpty()){
			removeTeacher.setBounds(217,300,250,35);
			addTeacherCount.setBounds(477,300,50,35);
			addTeacher.setBounds(537,300,250,35);
		}else{
			Y = teacherNameInput.get(teacherNameInput.size()-1).getY();
			removeTeacher.setBounds(217,Y+100,250,35);
			addTeacherCount.setBounds(477,Y+100,50,35);
			addTeacher.setBounds(537,Y+100,250,35);
		}
		
		Y = addTeacher.getY();
		subjectDefaultLabel[0].setBounds(45,Y+100,335,35);
		subjectDefaultLabel[1].setBounds(524,Y+100,335,35);
		subjectDefaultLabel[2].setBounds(45,Y+150,335,35);
		subjectDefaultLabel[3].setBounds(524,Y+150,335,35);
		subjectDefaultText[0].setBounds(380,Y+104,100,35);
		subjectDefaultText[1].setBounds(859,Y+104,100,35);
		subjectDefaultText[2].setBounds(380,Y+154,100,35);
		subjectDefaultText[3].setBounds(859,Y+154,100,35);
		if(subjectNameInput.isEmpty()){
			for(int i=0;i<4;i++){
				subjectDefaultLabel[i].setVisible(false);
				subjectDefaultText[i].setVisible(false);
			}
		}else{
			for(int i=0;i<4;i++){
				subjectDefaultLabel[i].setVisible(true);
				subjectDefaultText[i].setVisible(true);
			}
		}
		
		Y = subjectDefaultLabel[3].getY();
		for(int i=0;i<subjectNameInput.size();i++){
			subjectNameInput.get(i).setBounds(235,Y+100+(i*150),495,35);
			subjectNameCross.get(i).setBounds(735,Y+100+(i*150),i21.getIconWidth(),i21.getIconHeight());
			haveLecture.get(i).setBounds(52,Y+100+(i*150),110,35);
			havePractical.get(i).setBounds(832,Y+100+(i*150),120,35);
			timePerLecture.get(i).setBounds(52,Y+150+(i*150),210,35);
			lecturePerWeek.get(i).setBounds(272,Y+150+(i*150),210,35);
			timePerPractical.get(i).setBounds(522,Y+150+(i*150),210,35);
			practicalPerWeek.get(i).setBounds(742,Y+150+(i*150),210,35);
		}
		
		if(subjectNameInput.isEmpty()){
			Y = addTeacher.getY();
			removeSubject.setBounds(217,Y+150,250,35);
			addSubjectCount.setBounds(477,Y+150,50,35);
			addSubject.setBounds(537,Y+150,250,35);
		}else{
			Y = practicalPerWeek.get(practicalPerWeek.size()-1).getY();
			removeSubject.setBounds(217,Y+100,250,35);
			addSubjectCount.setBounds(477,Y+100,50,35);
			addSubject.setBounds(537,Y+100,250,35);
		}
		
		noteShortForm.setBounds(0,addSubject.getY()+150,1004,30);
		
		Y = (addSubject.getY()+204)-ep[0].getHeight();
		ep[0].setBounds(ep[0].getX(),ep[0].getY()-Y,ep[0].getWidth(),ep[0].getHeight()+Y);
		if(ep[0].getY()>0){
			ep[0].setBounds(ep[0].getX(),0,ep[0].getWidth(),ep[0].getHeight());
		}else if(ep[0].getY()<(654-ep[0].getHeight())){
			ep[0].setBounds(ep[0].getX(),654-ep[0].getHeight(),ep[0].getWidth(),ep[0].getHeight());
		}
		
		SetEditPanelValue(0);
		
	}

	public void SortFirstEditPage(){
		
		for(int i=0;i<teacherNameInput.size();i++){
			if(teacherNameInput.get(i).getText().equals("Enter Teacher Name")){
				ep[0].remove(teacherNameInput.get(i));
				ep[0].remove(teacherNameCross.get(i));
				teacherNameInput.remove(i);
				teacherNameCross.remove(i);
				
				i--;
			}
		}
		
		for(int i=0;i<subjectNameInput.size();i++){
			if(subjectNameInput.get(i).getText().equals("Enter Subject Name")){
				ep[0].remove(subjectNameInput.get(i));
				ep[0].remove(subjectNameCross.get(i));
				ep[0].remove(haveLecture.get(i));
				ep[0].remove(havePractical.get(i));
				ep[0].remove(timePerLecture.get(i));
				ep[0].remove(lecturePerWeek.get(i));
				ep[0].remove(timePerPractical.get(i));
				ep[0].remove(practicalPerWeek.get(i));
				
				subjectNameInput.remove(i);
				subjectNameCross.remove(i);
				haveLecture.remove(i);
				havePractical.remove(i);
				timePerLecture.remove(i);
				lecturePerWeek.remove(i);
				timePerPractical.remove(i);
				practicalPerWeek.remove(i);
				
				i--;
			}
		}
		
		for(int i=0;i<teacherNameInput.size()-1;i++){
			for(int j=i+1;j<teacherNameInput.size();j++){
				if(teacherNameInput.get(i).getText().equals(teacherNameInput.get(j).getText())){
					ep[0].remove(teacherNameInput.get(j));
					ep[0].remove(teacherNameCross.get(j));
					teacherNameInput.remove(j);
					teacherNameCross.remove(j);
					
					j--;
				}
			}
		}
		
		for(int i=0;i<subjectNameInput.size()-1;i++){
			for(int j=i+1;j<subjectNameInput.size();j++){
				if(subjectNameInput.get(i).getText().equals(subjectNameInput.get(j).getText())){
					ep[0].remove(subjectNameInput.get(j));
					ep[0].remove(subjectNameCross.get(j));
					ep[0].remove(haveLecture.get(j));
					ep[0].remove(havePractical.get(j));
					ep[0].remove(timePerLecture.get(j));
					ep[0].remove(lecturePerWeek.get(j));
					ep[0].remove(timePerPractical.get(j));
					ep[0].remove(practicalPerWeek.get(j));
					
					subjectNameInput.remove(j);
					subjectNameCross.remove(j);
					haveLecture.remove(j);
					havePractical.remove(j);
					timePerLecture.remove(j);
					lecturePerWeek.remove(j);
					timePerPractical.remove(j);
					practicalPerWeek.remove(j);
					
					j--;
				}
			}
		}
		
		for(int i=0;i<teacherNameInput.size();i++){
            for(int j=i+1;j<teacherNameInput.size();j++){
                if(teacherNameInput.get(i).getText().compareTo(teacherNameInput.get(j).getText()) > 0) {
                   	Collections.swap(teacherNameInput,i,j);
					Collections.swap(teacherNameCross,i,j);
                }
            }
        }
		
		for(int i=0;i<subjectNameInput.size();i++){
            for(int j=i+1;j<subjectNameInput.size();j++){
                if(subjectNameInput.get(i).getText().compareTo(subjectNameInput.get(j).getText()) > 0) {
                    Collections.swap(subjectNameInput,i,j);
					Collections.swap(subjectNameCross,i,j);
					Collections.swap(haveLecture,i,j);
					Collections.swap(timePerLecture,i,j);
					Collections.swap(lecturePerWeek,i,j);
					Collections.swap(havePractical,i,j);
					Collections.swap(timePerPractical,i,j);
					Collections.swap(practicalPerWeek,i,j);
                }
            }
        }
		
		for(int i=0;i<classInputPanel.size();i++){
			for(int j=0;j<divisionInputPanel.get(i).size();j++){
				try{
					for(int k=0;k<subjectChoosePanel.get(i).get(j).size();k++){
						String selectedItem = (String)subjectChoose.get(i).get(j).get(k).getSelectedItem();
						subjectChoose.get(i).get(j).get(k).removeAllItems();
						subjectChoose.get(i).get(j).get(k).addItem("Select Subject For Lecture");
						for(int x=0;x<subjectNameInput.size();x++){
							if(haveLecture.get(x).isSelected()){
								subjectChoose.get(i).get(j).get(k).addItem(subjectNameInput.get(x).getText());
							}
						}
						for(int x=0;x<subjectChoose.get(i).get(j).get(k).getItemCount();x++){
							String str = (String)subjectChoose.get(i).get(j).get(k).getItemAt(x);
							if(str.equals(selectedItem)){
								subjectChoose.get(i).get(j).get(k).setSelectedIndex(x);
							}
						}
						if(subjectChoose.get(i).get(j).get(k).getSelectedIndex() == 0){
							subjectChoose.get(i).get(j).get(k).setForeground(new Color(102,178,255));
							subjectChoose.get(i).get(j).get(k).setFont(new Font("TimesRoman",Font.BOLD+Font.ITALIC,25));
						}
					}
				}catch(Exception e){}
			}
		}
		
		for(int i=0;i<classInputPanel.size();i++){
			for(int j=0;j<divisionInputPanel.get(i).size();j++){
				try{
					for(int k=0;k<subjectChoosePanel.get(i).get(j).size();k++){
						for(int l=0;l<subjectTeacherChoosePanel.get(i).get(j).get(k).size();l++){
							String selectedItem = (String)subjectTeacherChoose.get(i).get(j).get(k).get(l).getSelectedItem();
							subjectTeacherChoose.get(i).get(j).get(k).get(l).removeAllItems();
							subjectTeacherChoose.get(i).get(j).get(k).get(l).addItem("Select Teacher For Lecture");
							for(int x=0;x<teacherNameInput.size();x++){
								subjectTeacherChoose.get(i).get(j).get(k).get(l).addItem(teacherNameInput.get(x).getText());
							}
							for(int x=0;x<subjectTeacherChoose.get(i).get(j).get(k).get(l).getItemCount();x++){
								String str = (String)subjectTeacherChoose.get(i).get(j).get(k).get(l).getItemAt(x);
								if(str.equals(selectedItem)){
									subjectTeacherChoose.get(i).get(j).get(k).get(l).setSelectedIndex(x);
								}
							}
							if(subjectTeacherChoose.get(i).get(j).get(k).get(l).getSelectedIndex() == 0){
								subjectTeacherChoose.get(i).get(j).get(k).get(l).setForeground(new Color(102,178,255));
								subjectTeacherChoose.get(i).get(j).get(k).get(l).setFont(new Font("TimesRoman",Font.BOLD+Font.ITALIC,25));
							}
						}
					}
				}catch(Exception e){}
			}
		}
		
		for(int i=0;i<classInputPanel.size();i++){
			for(int j=0;j<divisionInputPanel.get(i).size();j++){
				try{
					for(int k=0;k<batchInputPanel.get(i).get(j).size();k++){
						for(int l=0;l<practicalSubjectChoosePanel.get(i).get(j).get(k).size();l++){
							String selectedItem = (String)practicalSubjectChoose.get(i).get(j).get(k).get(l).getSelectedItem();
							practicalSubjectChoose.get(i).get(j).get(k).get(l).removeAllItems();
							practicalSubjectChoose.get(i).get(j).get(k).get(l).addItem("Select Subject For Practical");
							for(int x=0;x<subjectNameInput.size();x++){
								if(havePractical.get(x).isSelected()){
									practicalSubjectChoose.get(i).get(j).get(k).get(l).addItem(subjectNameInput.get(x).getText());
								}
							}
							for(int x=0;x<practicalSubjectChoose.get(i).get(j).get(k).get(l).getItemCount();x++){
								String str = (String)practicalSubjectChoose.get(i).get(j).get(k).get(l).getItemAt(x);
								if(str.equals(selectedItem)){
									practicalSubjectChoose.get(i).get(j).get(k).get(l).setSelectedIndex(x);
								}
							}
							if(practicalSubjectChoose.get(i).get(j).get(k).get(l).getSelectedIndex() == 0){
								practicalSubjectChoose.get(i).get(j).get(k).get(l).setForeground(new Color(102,178,255));
								practicalSubjectChoose.get(i).get(j).get(k).get(l).setFont(new Font("TimesRoman",Font.BOLD+Font.ITALIC,25));
							}
						}
					}
				}catch(Exception e){}
			}
		}
		
		for(int i=0;i<classInputPanel.size();i++){
			for(int j=0;j<divisionInputPanel.get(i).size();j++){
				try{
					for(int k=0;k<batchInputPanel.get(i).get(j).size();k++){
						for(int l=0;l<practicalSubjectChoosePanel.get(i).get(j).get(k).size();l++){
							for(int m=0;m<practicalSubjectTeacherChoosePanel.get(i).get(j).get(k).get(l).size();m++){
								String selectedItem = (String)practicalSubjectTeacherChoose.get(i).get(j).get(k).get(l).get(m).getSelectedItem();
								practicalSubjectTeacherChoose.get(i).get(j).get(k).get(l).get(m).removeAllItems();
								practicalSubjectTeacherChoose.get(i).get(j).get(k).get(l).get(m).addItem("Select Teacher For Practical");
								for(int x=0;x<teacherNameInput.size();x++){
									practicalSubjectTeacherChoose.get(i).get(j).get(k).get(l).get(m).addItem(teacherNameInput.get(x).getText());
								}
								for(int x=0;x<practicalSubjectTeacherChoose.get(i).get(j).get(k).get(l).get(m).getItemCount();x++){
									String str = (String)practicalSubjectTeacherChoose.get(i).get(j).get(k).get(l).get(m).getItemAt(x);
									if(str.equals(selectedItem)){
										practicalSubjectTeacherChoose.get(i).get(j).get(k).get(l).get(m).setSelectedIndex(x);
									}
								}
								if(practicalSubjectTeacherChoose.get(i).get(j).get(k).get(l).get(m).getSelectedIndex() == 0){
									practicalSubjectTeacherChoose.get(i).get(j).get(k).get(l).get(m).setForeground(new Color(102,178,255));
									practicalSubjectTeacherChoose.get(i).get(j).get(k).get(l).get(m).setFont(new Font("TimesRoman",Font.BOLD+Font.ITALIC,25));
								}
							}
						}
					}
				}catch(Exception e){}
			}
		}
		
		RearrangeFirstEditPage();
		
	}
	
	                  //***********************************************//
	
	public void SecondEditPage(){
		
		i22 = new ImageIcon("IconsTimeTable\\cross1.png");
		i22 = new ImageIcon(i22.getImage().getScaledInstance(34,34,java.awt.Image.SCALE_SMOOTH));
		i23 = new ImageIcon("IconsTimeTable\\add1.png");
		i23 = new ImageIcon(i23.getImage().getScaledInstance(34,34,java.awt.Image.SCALE_SMOOTH));
		
		classInputAdd = new JButton(i23);
		classInputAdd.setOpaque(false);
		classInputAdd.setContentAreaFilled(false);
		classInputAdd.setBorderPainted(false);
		classInputAdd.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
		classInputAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				ClassInputAddFunction();
			}
		});
		
		ClassInputAddFunction();
		
		SetEditPanelValue(0);
		
	}
	
	public void ClassInputAddFunction(){
		
		JPanel tempJPanel = new JPanel();
		tempJPanel.setOpaque(false);
		tempJPanel.setBorder(BorderFactory.createMatteBorder(1,0,1,0,new Color(102,178,255)));
		tempJPanel.setLayout(null);
		classInputPanel.add(tempJPanel);
		if(ep[1].isVisible()){
			ep[1].add(classInputPanel.get(classInputPanel.size()-1));
		}else{
			ep[2].add(classInputPanel.get(classInputPanel.size()-1));
		}
		
		JTextField tempJTextField = new JTextField("Enter Class Name");
		tempJTextField.setBackground(new Color(192,255,255));
		tempJTextField.setForeground(new Color(102,178,255));
		tempJTextField.setFont(new Font("TimesRoman",Font.BOLD+Font.ITALIC,25));
		tempJTextField.setHorizontalAlignment(JTextField.CENTER);
		tempJTextField.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e){
				for(int i=0;i<classInput.size();i++){
					if(classInput.get(i).isFocusOwner()){
						if(classInput.get(i).getText().equals("Enter Class Name")){
							classInput.get(i).setText("");
							classInput.get(i).setForeground(new Color(0,128,255));
							classInput.get(i).setFont(new Font("TimesRoman",Font.BOLD,25));
						}
						lastFocused = i;
					}
				}
			}
			public void focusLost(FocusEvent e){
				int i = lastFocused;
				if(classInput.get(i).getText().equals("")){
					classInput.get(i).setText("Enter Class Name");
					classInput.get(i).setForeground(new Color(102,178,255));
					classInput.get(i).setFont(new Font("TimesRoman",Font.BOLD+Font.ITALIC,25));
				}
			}
		});
		classInput.add(tempJTextField);
		classInputPanel.get(classInputPanel.size()-1).add(classInput.get(classInput.size()-1));
		
		if(classInput.size()>1){
			JButton tempJButton = new JButton(i22);
			tempJButton.setOpaque(false);
			tempJButton.setContentAreaFilled(false);
			tempJButton.setBorderPainted(false);
			tempJButton.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
			tempJButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					
					for(int i=0;i<classInputPanel.size();i++){
						try{
							if(classInputCross.get(i).getModel().isArmed()){
								if(ep[1].isVisible()){
									ep[1].remove(classInputPanel.get(i));
								}else{
									ep[2].remove(classInputPanel.get(i));
								}
								
								try{
									practicalSubjectTeacherChooseCross.remove(i);
								}catch(Exception e){}
								practicalSubjectTeacherChoose.remove(i);
								practicalSubjectTeacherChoosePanel.remove(i);
								practicalSubjectTeacherChooseAdd.remove(i);
								try{
									practicalSubjectChooseCross.remove(i);
								}catch(Exception e){}
								practicalSubjectChoose.remove(i);
								practicalSubjectChoosePanel.remove(i);
								practicalSubjectChooseAdd.remove(i);
								try{
									batchInputCross.remove(i);
								}catch(Exception e){}
								batchInput.remove(i);
								batchInputPanel.remove(i);
								batchInputAdd.remove(i);
								
								try{
									subjectTeacherChooseCross.remove(i);
								}catch(Exception e){}
								subjectTeacherChoose.remove(i);
								subjectTeacherChoosePanel.remove(i);
								subjectTeacherChooseAdd.remove(i);
								try{
									subjectChooseCross.remove(i);
								}catch(Exception e){}
								subjectChoose.remove(i);
								subjectChoosePanel.remove(i);
								subjectChooseAdd.remove(i);
								try{
									divisionInputCross.remove(i);
								}catch(Exception e){}
								divisionInput.remove(i);
								divisionInputPanel.remove(i);
								divisionInputAdd.remove(i);
								classInputCross.remove(i);
								classInput.remove(i);
								classInputPanel.remove(i);
								
								break;
							}
						}catch(Exception e){}
					}
					
					if(ep[1].isVisible()){
						RearrangeSecondEditPage();
					}else{
						RearrangeThirdEditPage();
					}
				}
			});
			classInputCross.add(tempJButton);
			classInputPanel.get(classInputPanel.size()-2).add(classInputCross.get(classInputCross.size()-1));
		}
		classInputPanel.get(classInputPanel.size()-1).add(classInputAdd);
		
		DivisionInputAddFunction(classInput.size()-1);
		
	}
	
	public void DivisionInputAddFunction(int i){
		
		JPanel tempJPanel = new JPanel();
		tempJPanel.setOpaque(false);
		tempJPanel.setBorder(BorderFactory.createMatteBorder(1,0,1,0,new Color(102,178,255)));
		tempJPanel.setLayout(null);
		if(divisionInputPanel.size()-1<i){
			for(int x=divisionInputPanel.size()-1;x<i;x++){
				divisionInputPanel.add(new ArrayList<JPanel>());
			}
		}
		divisionInputPanel.get(i).add(tempJPanel);
		classInputPanel.get(i).add(divisionInputPanel.get(i).get(divisionInputPanel.get(i).size()-1));
		
		JTextField tempJTextField = new JTextField("Enter Division Name");
		tempJTextField.setBackground(new Color(192,255,255));
		tempJTextField.setForeground(new Color(102,178,255));
		tempJTextField.setFont(new Font("TimesRoman",Font.BOLD+Font.ITALIC,25));
		tempJTextField.setHorizontalAlignment(JTextField.CENTER);
		if(divisionInput.size()-1<i){
			for(int x=divisionInput.size()-1;x<i;x++){
				divisionInput.add(new ArrayList<JTextField>());
			}
		}
		tempJTextField.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e){
				for(int i=0;i<classInput.size();i++){
					for(int j=0;j<divisionInput.get(i).size();j++){
						if(divisionInput.get(i).get(j).isFocusOwner()){
							if(divisionInput.get(i).get(j).getText().equals("Enter Division Name")){
								divisionInput.get(i).get(j).setText("");
								divisionInput.get(i).get(j).setForeground(new Color(0,128,255));
								divisionInput.get(i).get(j).setFont(new Font("TimesRoman",Font.BOLD,25));
							}
							lastFocused = i;
							lastFocused1 = j;
						}
					}
				}
			}
			public void focusLost(FocusEvent e){
				int i = lastFocused;
				int j = lastFocused1;
				if(divisionInput.get(i).get(j).getText().equals("")){
					divisionInput.get(i).get(j).setText("Enter Division Name");
					divisionInput.get(i).get(j).setForeground(new Color(102,178,255));
					divisionInput.get(i).get(j).setFont(new Font("TimesRoman",Font.BOLD+Font.ITALIC,25));
				}
			}
		});
		divisionInput.get(i).add(tempJTextField);
		divisionInputPanel.get(i).get(divisionInputPanel.get(i).size()-1).add(divisionInput.get(i).get(divisionInput.get(i).size()-1));
		
		if(divisionInput.get(i).size()>1){
			JButton tempJButton = new JButton(i22);
			tempJButton.setOpaque(false);
			tempJButton.setContentAreaFilled(false);
			tempJButton.setBorderPainted(false);
			tempJButton.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
			if(divisionInputCross.size()-1<i){
				for(int x=divisionInputCross.size()-1;x<i;x++){
					divisionInputCross.add(new ArrayList<JButton>());
				}
			}
			tempJButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					
					boolean done = false;
					
					for(int i=0;i<classInputPanel.size();i++){
						for(int j=0;j<divisionInputPanel.get(i).size();j++){
							try{
								if(divisionInputCross.get(i).get(j).getModel().isArmed()){
									classInputPanel.get(i).remove(divisionInputPanel.get(i).get(j));
									
									try{
										practicalSubjectTeacherChooseCross.get(i).remove(j);
									}catch(Exception e){}
									practicalSubjectTeacherChoose.get(i).remove(j);
									practicalSubjectTeacherChoosePanel.get(i).remove(j);
									practicalSubjectTeacherChooseAdd.get(i).remove(j);
									try{
										practicalSubjectChooseCross.get(i).remove(j);
									}catch(Exception e){}
									practicalSubjectChoose.get(i).remove(j);
									practicalSubjectChoosePanel.get(i).remove(j);
									practicalSubjectChooseAdd.get(i).remove(j);
									try{
										batchInputCross.get(i).remove(j);
									}catch(Exception e){}
									batchInput.get(i).remove(j);
									batchInputPanel.get(i).remove(j);
									batchInputAdd.get(i).remove(j);
									
									try{
										subjectTeacherChooseCross.get(i).remove(j);
									}catch(Exception e){}
									subjectTeacherChoose.get(i).remove(j);
									subjectTeacherChoosePanel.get(i).remove(j);
									subjectTeacherChooseAdd.get(i).remove(j);
									try{
										subjectChooseCross.get(i).remove(j);
									}catch(Exception e){}
									subjectChoose.get(i).remove(j);
									subjectChoosePanel.get(i).remove(j);
									subjectChooseAdd.get(i).remove(j);
									divisionInputCross.get(i).remove(j);
									divisionInput.get(i).remove(j);
									divisionInputPanel.get(i).remove(j);
									
									done = true;
									break;
								}
							}catch(Exception e){}
						}
						if(done==true) { break; }
					}
					
					if(ep[1].isVisible()){
						RearrangeSecondEditPage();
					}else{
						RearrangeThirdEditPage();
					}
				}
			});
			divisionInputCross.get(i).add(tempJButton);
			divisionInputPanel.get(i).get(divisionInputPanel.get(i).size()-2).add(divisionInputCross.get(i).get(divisionInputCross.get(i).size()-1));
		}else{
			JButton tempJButton = new JButton(i23);
			tempJButton.setOpaque(false);
			tempJButton.setContentAreaFilled(false);
			tempJButton.setBorderPainted(false);
			tempJButton.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
			tempJButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					for(int i=0;i<classInputPanel.size();i++){
						if(divisionInputAdd.get(i).getModel().isArmed()){
							DivisionInputAddFunction(i);
						}
					}
				}
			});
			divisionInputAdd.add(tempJButton);
		}
		divisionInputPanel.get(i).get(divisionInputPanel.get(i).size()-1).add(divisionInputAdd.get(i));
		
		if(ep[1].isVisible()){
			BatchInputAddFunction(i,divisionInput.get(i).size()-1);
			SetEditPanelValue(1);
			SubjectChooseAddFucntion(i,divisionInput.get(i).size()-1);
		}else{
			SubjectChooseAddFucntion(i,divisionInput.get(i).size()-1);
			SetEditPanelValue(2);
			BatchInputAddFunction(i,divisionInput.get(i).size()-1);
		}
		
	}
	
	public void SubjectChooseAddFucntion(int i,int j){
		
		JPanel tempJPanel = new JPanel();
		tempJPanel.setOpaque(false);
		tempJPanel.setBorder(BorderFactory.createMatteBorder(1,0,1,0,new Color(102,178,255)));
		tempJPanel.setLayout(null);
		if(subjectChoosePanel.size()-1<i){
			for(int x=subjectChoosePanel.size()-1;x<i;x++){
				subjectChoosePanel.add(new ArrayList<ArrayList<JPanel>>());
			}
		}
		if(subjectChoosePanel.get(i).size()-1<j){
			for(int x=subjectChoosePanel.get(i).size()-1;x<j;x++){
				subjectChoosePanel.get(i).add(new ArrayList<JPanel>());
			}
		}
		if(ep[1].isVisible()){
			tempJPanel.setVisible(true);
		}else{
			tempJPanel.setVisible(false);
		}
		subjectChoosePanel.get(i).get(j).add(tempJPanel);
		divisionInputPanel.get(i).get(j).add(subjectChoosePanel.get(i).get(j).get(subjectChoosePanel.get(i).get(j).size()-1));
		
		JComboBox tempJComboBox = new JComboBox();
		tempJComboBox = new JComboBox();
		tempJComboBox.setBackground(new Color(192,255,255));
		if(subjectChoose.size()-1<i){
			for(int x=subjectChoose.size()-1;x<i;x++){
				subjectChoose.add(new ArrayList<ArrayList<JComboBox>>());
			}
		}
		if(subjectChoose.get(i).size()-1<j){
			for(int x=subjectChoose.get(i).size()-1;x<j;x++){
				subjectChoose.get(i).add(new ArrayList<JComboBox>());
			}
		}
		tempJComboBox.setForeground(new Color(102,178,255));
		tempJComboBox.setFont(new Font("TimesRoman",Font.BOLD+Font.ITALIC,25));
		DefaultListCellRenderer listRenderer = new DefaultListCellRenderer();
		listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		tempJComboBox.setRenderer(listRenderer);
		tempJComboBox.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e){
				for(int i=0;i<classInput.size();i++){
					for(int j=0;j<divisionInput.get(i).size();j++){
						for(int k=0;k<subjectChoose.get(i).get(j).size();k++){
							if(subjectChoose.get(i).get(j).get(k).isFocusOwner()){
								if(subjectChoose.get(i).get(j).get(k).getSelectedItem().equals("Select Subject For Lecture")||subjectChoose.get(i).get(j).get(k).getItemAt(0).equals("Select Subject For Lecture")){
									subjectChoose.get(i).get(j).get(k).insertItemAt("- - - - - - - - - -",0);
									subjectChoose.get(i).get(j).get(k).removeItemAt(1);
									subjectChoose.get(i).get(j).get(k).setForeground(new Color(0,128,255));
									subjectChoose.get(i).get(j).get(k).setFont(new Font("TimesRoman",Font.BOLD,25));
								}
								lastFocused = i;
								lastFocused1 = j;
								lastFocused2 = k;
							}
						}
					}
				}
			}
			public void focusLost(FocusEvent e){
				int i = lastFocused;
				int j = lastFocused1;
				int k = lastFocused2;
				if(subjectChoose.get(i).get(j).get(k).getSelectedItem().equals("- - - - - - - - - -")){
					subjectChoose.get(i).get(j).get(k).insertItemAt("Select Subject For Lecture",0);
					subjectChoose.get(i).get(j).get(k).removeItemAt(1);
					subjectChoose.get(i).get(j).get(k).setForeground(new Color(102,178,255));
					subjectChoose.get(i).get(j).get(k).setFont(new Font("TimesRoman",Font.BOLD+Font.ITALIC,25));
				}
			}
		});
		subjectChoose.get(i).get(j).add(tempJComboBox);
		subjectChoosePanel.get(i).get(j).get(subjectChoosePanel.get(i).get(j).size()-1).add(subjectChoose.get(i).get(j).get(subjectChoose.get(i).get(j).size()-1));
		
		if(subjectChoose.get(i).get(j).size()>1){
			JButton tempJButton = new JButton(i22);
			tempJButton.setOpaque(false);
			tempJButton.setContentAreaFilled(false);
			tempJButton.setBorderPainted(false);
			tempJButton.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
			if(subjectChooseCross.size()-1<i){
				for(int x=subjectChooseCross.size()-1;x<i;x++){
					subjectChooseCross.add(new ArrayList<ArrayList<JButton>>());
				}
			}
			if(subjectChooseCross.get(i).size()-1<j){
				for(int x=subjectChooseCross.get(i).size()-1;x<j;x++){
					subjectChooseCross.get(i).add(new ArrayList<JButton>());
				}
			}
			tempJButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					
					boolean done = false;
					
					for(int i=0;i<classInputPanel.size();i++){
						for(int j=0;j<divisionInputPanel.get(i).size();j++){
							for(int k=0;k<subjectChoosePanel.get(i).get(j).size();k++){
								try{
									if(subjectChooseCross.get(i).get(j).get(k).getModel().isArmed()){
										divisionInputPanel.get(i).get(j).remove(subjectChoosePanel.get(i).get(j).get(k));
										
										try{
											subjectTeacherChooseCross.get(i).get(j).remove(k);
										}catch(Exception e){}
										subjectTeacherChoose.get(i).get(j).remove(k);
										subjectTeacherChoosePanel.get(i).get(j).remove(k);
										subjectTeacherChooseAdd.get(i).get(j).remove(k);
										subjectChoose.get(i).get(j).remove(k);
										subjectChooseCross.get(i).get(j).remove(k);
										subjectChoosePanel.get(i).get(j).remove(k);
										
										done = true;
										break;
									}
								}catch(Exception e){}
							}
							if(done==true) { break; }
						}
						if(done==true) { break; }
					}
					
					RearrangeSecondEditPage();
				}
			});
			subjectChooseCross.get(i).get(j).add(tempJButton);
			subjectChoosePanel.get(i).get(j).get(subjectChoosePanel.get(i).get(j).size()-2).add(subjectChooseCross.get(i).get(j).get(subjectChooseCross.get(i).get(j).size()-1));
		}else{
			JButton tempJButton = new JButton(i23);
			tempJButton.setOpaque(false);
			tempJButton.setContentAreaFilled(false);
			tempJButton.setBorderPainted(false);
			tempJButton.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
			if(subjectChooseAdd.size()-1<i){
				for(int x=subjectChooseAdd.size()-1;x<i;x++){
					subjectChooseAdd.add(new ArrayList<JButton>());
				}
			}
			tempJButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					for(int i=0;i<classInputPanel.size();i++){
						for(int j=0;j<divisionInputPanel.get(i).size();j++){
							if(subjectChooseAdd.get(i).get(j).getModel().isArmed()){
								SubjectChooseAddFucntion(i,j);
							}
						}
					}
				}
			});
			subjectChooseAdd.get(i).add(tempJButton);
		}
		subjectChoosePanel.get(i).get(j).get(subjectChoosePanel.get(i).get(j).size()-1).add(subjectChooseAdd.get(i).get(j));
		
		SubjectTeacherChooseAddFunction(i,j,subjectChoose.get(i).get(j).size()-1);
		
	}
	
	public void SubjectTeacherChooseAddFunction(int i,int j,int k){
		
		JPanel tempJPanel = new JPanel();
		tempJPanel.setOpaque(false);
		tempJPanel.setBorder(BorderFactory.createMatteBorder(0,0,0,0,new Color(102,178,255)));
		tempJPanel.setLayout(null);
		if(subjectTeacherChoosePanel.size()-1<i){
			for(int x=subjectTeacherChoosePanel.size()-1;x<i;x++){
				subjectTeacherChoosePanel.add(new ArrayList<ArrayList<ArrayList<JPanel>>>());
			}
		}
		if(subjectTeacherChoosePanel.get(i).size()-1<j){
			for(int x=subjectTeacherChoosePanel.get(i).size()-1;x<j;x++){
				subjectTeacherChoosePanel.get(i).add(new ArrayList<ArrayList<JPanel>>());
			}
		}
		if(subjectTeacherChoosePanel.get(i).get(j).size()-1<k){
			for(int x=subjectTeacherChoosePanel.get(i).get(j).size()-1;x<k;x++){
				subjectTeacherChoosePanel.get(i).get(j).add(new ArrayList<JPanel>());
			}
		}
		subjectTeacherChoosePanel.get(i).get(j).get(k).add(tempJPanel);
		subjectChoosePanel.get(i).get(j).get(k).add(subjectTeacherChoosePanel.get(i).get(j).get(k).get(subjectTeacherChoosePanel.get(i).get(j).get(k).size()-1));
		
		JComboBox tempJComboBox = new JComboBox();
		tempJComboBox = new JComboBox();
		tempJComboBox.setBackground(new Color(192,255,255));
		if(subjectTeacherChoose.size()-1<i){
			for(int x=subjectTeacherChoose.size()-1;x<i;x++){
				subjectTeacherChoose.add(new ArrayList<ArrayList<ArrayList<JComboBox>>>());
			}
		}
		if(subjectTeacherChoose.get(i).size()-1<j){
			for(int x=subjectTeacherChoose.get(i).size()-1;x<j;x++){
				subjectTeacherChoose.get(i).add(new ArrayList<ArrayList<JComboBox>>());
			}
		}
		if(subjectTeacherChoose.get(i).get(j).size()-1<k){
			for(int x=subjectTeacherChoose.get(i).get(j).size()-1;x<k;x++){
				subjectTeacherChoose.get(i).get(j).add(new ArrayList<JComboBox>());
			}
		}
		tempJComboBox.setForeground(new Color(102,178,255));
		tempJComboBox.setFont(new Font("TimesRoman",Font.BOLD+Font.ITALIC,25));
		DefaultListCellRenderer listRenderer = new DefaultListCellRenderer();
		listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		tempJComboBox.setRenderer(listRenderer);
		tempJComboBox.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e){
				for(int i=0;i<classInput.size();i++){
					for(int j=0;j<divisionInput.get(i).size();j++){
						for(int k=0;k<subjectChoose.get(i).get(j).size();k++){
							for(int l=0;l<subjectTeacherChoose.get(i).get(j).get(k).size();l++){
								if(subjectTeacherChoose.get(i).get(j).get(k).get(l).isFocusOwner()){
									if(subjectTeacherChoose.get(i).get(j).get(k).get(l).getSelectedItem().equals("Select Teacher For Lecture")||subjectTeacherChoose.get(i).get(j).get(k).get(l).getItemAt(0).equals("Select Teacher For Lecture")){
										subjectTeacherChoose.get(i).get(j).get(k).get(l).insertItemAt("- - - - - - - - - -",0);
										subjectTeacherChoose.get(i).get(j).get(k).get(l).removeItemAt(1);
										subjectTeacherChoose.get(i).get(j).get(k).get(l).setForeground(new Color(0,128,255));
										subjectTeacherChoose.get(i).get(j).get(k).get(l).setFont(new Font("TimesRoman",Font.BOLD,25));
									}
									lastFocused = i;
									lastFocused1 = j;
									lastFocused2 = k;
									lastFocused3 = l;
								}
							}
						}
					}
				}
			}
			public void focusLost(FocusEvent e){
				int i = lastFocused;
				int j = lastFocused1;
				int k = lastFocused2;
				int l = lastFocused3;
				if(subjectTeacherChoose.get(i).get(j).get(k).get(l).getSelectedItem().equals("- - - - - - - - - -")){
					subjectTeacherChoose.get(i).get(j).get(k).get(l).insertItemAt("Select Teacher For Lecture",0);
					subjectTeacherChoose.get(i).get(j).get(k).get(l).removeItemAt(1);
					subjectTeacherChoose.get(i).get(j).get(k).get(l).setForeground(new Color(102,178,255));
					subjectTeacherChoose.get(i).get(j).get(k).get(l).setFont(new Font("TimesRoman",Font.BOLD+Font.ITALIC,25));
				}
			}
		});
		subjectTeacherChoose.get(i).get(j).get(k).add(tempJComboBox);
		subjectTeacherChoosePanel.get(i).get(j).get(k).get(subjectTeacherChoosePanel.get(i).get(j).get(k).size()-1).add(subjectTeacherChoose.get(i).get(j).get(k).get(subjectTeacherChoose.get(i).get(j).get(k).size()-1));
		
		if(subjectTeacherChoose.get(i).get(j).get(k).size()>1){
			JButton tempJButton = new JButton(i22);
			tempJButton.setOpaque(false);
			tempJButton.setContentAreaFilled(false);
			tempJButton.setBorderPainted(false);
			tempJButton.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
			if(subjectTeacherChooseCross.size()-1<i){
				for(int x=subjectTeacherChooseCross.size()-1;x<i;x++){
					subjectTeacherChooseCross.add(new ArrayList<ArrayList<ArrayList<JButton>>>());
				}
			}
			if(subjectTeacherChooseCross.get(i).size()-1<j){
				for(int x=subjectTeacherChooseCross.get(i).size()-1;x<j;x++){
					subjectTeacherChooseCross.get(i).add(new ArrayList<ArrayList<JButton>>());
				}
			}
			if(subjectTeacherChooseCross.get(i).get(j).size()-1<k){
				for(int x=subjectTeacherChooseCross.get(i).get(j).size()-1;x<k;x++){
					subjectTeacherChooseCross.get(i).get(j).add(new ArrayList<JButton>());
				}
			}
			tempJButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					
					boolean done = false;
					
					for(int i=0;i<classInputPanel.size();i++){
						for(int j=0;j<divisionInputPanel.get(i).size();j++){
							for(int k=0;k<subjectChoosePanel.get(i).get(j).size();k++){
								for(int l=0;l<subjectTeacherChoosePanel.get(i).get(j).get(k).size();l++){
									try{
										if(subjectTeacherChooseCross.get(i).get(j).get(k).get(l).getModel().isArmed()){
											subjectChoosePanel.get(i).get(j).get(k).remove(subjectTeacherChoosePanel.get(i).get(j).get(k).get(l));
											
											subjectTeacherChoose.get(i).get(j).get(k).remove(l);
											subjectTeacherChooseCross.get(i).get(j).get(k).remove(l);
											subjectTeacherChoosePanel.get(i).get(j).get(k).remove(l);
											
											break;
										}
									}catch(Exception e){}
								}
								if(done==true) { break; }
							}
							if(done==true) { break; }
						}
						if(done==true) { break; }
					}
					
					RearrangeSecondEditPage();
				}
			});
			subjectTeacherChooseCross.get(i).get(j).get(k).add(tempJButton);
			subjectTeacherChoosePanel.get(i).get(j).get(k).get(subjectTeacherChoosePanel.get(i).get(j).get(k).size()-2).add(subjectTeacherChooseCross.get(i).get(j).get(k).get(subjectTeacherChooseCross.get(i).get(j).get(k).size()-1));
		}else{
			JButton tempJButton = new JButton(i23);
			tempJButton.setOpaque(false);
			tempJButton.setContentAreaFilled(false);
			tempJButton.setBorderPainted(false);
			tempJButton.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
			if(subjectTeacherChooseAdd.size()-1<i){
				for(int x=subjectTeacherChooseAdd.size()-1;x<i;x++){
					subjectTeacherChooseAdd.add(new ArrayList<ArrayList<JButton>>());
				}
			}
			if(subjectTeacherChooseAdd.get(i).size()-1<j){
				for(int x=subjectTeacherChooseAdd.get(i).size()-1;x<j;x++){
					subjectTeacherChooseAdd.get(i).add(new ArrayList<JButton>());
				}
			}
			tempJButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					for(int i=0;i<classInputPanel.size();i++){
						for(int j=0;j<divisionInputPanel.get(i).size();j++){
							for(int k=0;k<subjectChoosePanel.get(i).get(j).size();k++){
								if(subjectTeacherChooseAdd.get(i).get(j).get(k).getModel().isArmed()){
									SubjectTeacherChooseAddFunction(i,j,k);
								}
							}
						}
					}
				}
			});
			subjectTeacherChooseAdd.get(i).get(j).add(tempJButton);
		}
		subjectTeacherChoosePanel.get(i).get(j).get(k).get(subjectTeacherChoosePanel.get(i).get(j).get(k).size()-1).add(subjectTeacherChooseAdd.get(i).get(j).get(k));
		
		RearrangeSecondEditPage();
		
	}
	
	public void RearrangeSecondEditPage(){
		
		int Size4 = (654/2)-37;
		
		for(int i=0;i<classInputPanel.size();i++){
			
			int Size3 = 0;
			
			for(int j=0;j<divisionInputPanel.get(i).size();j++){
				
				int Size2 = 0;
				
				for(int k=0;k<subjectChoosePanel.get(i).get(j).size();k++){
					
					int Size1 = 0;
					
					for(int l=0;l<subjectTeacherChoosePanel.get(i).get(j).get(k).size();l++){
						
						subjectTeacherChoosePanel.get(i).get(j).get(k).get(l).setBounds(770,(l*54)+10,535,54);
						subjectTeacherChoose.get(i).get(j).get(k).get(l).setBounds(0,10,495,34);
						if(l!=subjectTeacherChoosePanel.get(i).get(j).get(k).size()-1){
							subjectTeacherChooseCross.get(i).get(j).get(k).get(l).setBounds(500,10,i22.getIconWidth(),i22.getIconHeight());
						}else{
							subjectTeacherChooseAdd.get(i).get(j).get(k).setBounds(500,10,i23.getIconWidth(),i23.getIconHeight());
						}
						Size1 = (l*54)+54+20;
						
					}
					
					subjectChoosePanel.get(i).get(j).get(k).setBounds(770,Size2,1305,Size1);
					int Y = (Size1/2)-17;
					subjectChoose.get(i).get(j).get(k).setBounds(0,Y,495,34);
					if(k!=subjectChoosePanel.get(i).get(j).size()-1){
						subjectChooseCross.get(i).get(j).get(k).setBounds(500,Y,i22.getIconWidth(),i22.getIconHeight());
					}else{
						subjectChooseAdd.get(i).get(j).setBounds(500,Y,i23.getIconWidth(),i23.getIconHeight());
					}
					Size2 = Size2 + Size1;
					
				}
				
				divisionInputPanel.get(i).get(j).setBounds(770,Size3,2075,Size2);
				int Y = (Size2/2)-17;
				divisionInput.get(i).get(j).setBounds(0,Y,495,34);
				if(j!=divisionInputPanel.get(i).size()-1){
					divisionInputCross.get(i).get(j).setBounds(500,Y,i22.getIconWidth(),i22.getIconHeight());
				}else{
					divisionInputAdd.get(i).setBounds(500,Y,i23.getIconWidth(),i23.getIconHeight());
				}
				Size3 = Size3 + Size2;
				
			}
			
			classInputPanel.get(i).setBounds(235,Size4,2845,Size3);
			int Y = (Size3/2)-17;
			classInput.get(i).setBounds(0,Y,495,34);
			if(i!=classInputPanel.size()-1){
				classInputCross.get(i).setBounds(500,Y,i22.getIconWidth(),i22.getIconHeight());
			}else{
				classInputAdd.setBounds(500,Y,i23.getIconWidth(),i23.getIconHeight());
			}
			Size4 = Size4 + Size3;
			
			if(i==0&&i==classInputPanel.size()-1){
				classInputPanel.get(i).setBorder(BorderFactory.createMatteBorder(5,0,5,0,new Color(102,178,255)));
			}else if(i==0){
				classInputPanel.get(i).setBorder(BorderFactory.createMatteBorder(5,0,1,0,new Color(102,178,255)));
			}else if(i==classInputPanel.size()-1){
				classInputPanel.get(i).setBorder(BorderFactory.createMatteBorder(1,0,5,0,new Color(102,178,255)));
			}else{
				classInputPanel.get(i).setBorder(BorderFactory.createMatteBorder(1,0,1,0,new Color(102,178,255)));
			}
			
		}
		
		int Y = (classInputPanel.get(classInputPanel.size()-1).getY() + classInputPanel.get(classInputPanel.size()-1).getHeight())-lastSecondEditPanelSize;
		ep[1].setBounds(ep[1].getX(),ep[1].getY()-Y,ep[1].getWidth(),ep[1].getHeight()+Y);
		if(ep[1].getY()>0){
			ep[1].setBounds(ep[1].getX(),0,ep[1].getWidth(),ep[1].getHeight());
		}else if(ep[1].getY()<(654-ep[1].getHeight())){
			ep[1].setBounds(ep[1].getX(),654-ep[1].getHeight(),ep[1].getWidth(),ep[1].getHeight());
		}
		lastSecondEditPanelSize = classInputPanel.get(classInputPanel.size()-1).getY() + classInputPanel.get(classInputPanel.size()-1).getHeight();
		
		SortFirstEditPage();
		SetEditPanelValue(1);
		
	}
	
	                  //***********************************************//
	
	public void BatchInputAddFunction(int i,int j){
		
		JPanel tempJPanel = new JPanel();
		tempJPanel.setOpaque(false);
		tempJPanel.setBorder(BorderFactory.createMatteBorder(1,0,1,0,new Color(102,178,255)));
		tempJPanel.setLayout(null);
		if(batchInputPanel.size()-1<i){
			for(int x=batchInputPanel.size()-1;x<i;x++){
				batchInputPanel.add(new ArrayList<ArrayList<JPanel>>());
			}
		}
		if(batchInputPanel.get(i).size()-1<j){
			for(int x=batchInputPanel.get(i).size()-1;x<j;x++){
				batchInputPanel.get(i).add(new ArrayList<JPanel>());
			}
		}
		if(ep[2].isVisible()){
			tempJPanel.setVisible(true);
		}else{
			tempJPanel.setVisible(false);
		}
		batchInputPanel.get(i).get(j).add(tempJPanel);
		divisionInputPanel.get(i).get(j).add(batchInputPanel.get(i).get(j).get(batchInputPanel.get(i).get(j).size()-1));
		
		JTextField tempJTextField = new JTextField("Enter Batch Name");
		tempJTextField.setBackground(new Color(192,255,255));
		tempJTextField.setForeground(new Color(102,178,255));
		tempJTextField.setFont(new Font("TimesRoman",Font.BOLD+Font.ITALIC,25));
		tempJTextField.setHorizontalAlignment(JTextField.CENTER);
		if(batchInput.size()-1<i){
			for(int x=batchInput.size()-1;x<i;x++){
				batchInput.add(new ArrayList<ArrayList<JTextField>>());
			}
		}
		if(batchInput.get(i).size()-1<j){
			for(int x=batchInput.get(i).size()-1;x<j;x++){
				batchInput.get(i).add(new ArrayList<JTextField>());
			}
		}
		tempJTextField.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e){
				for(int i=0;i<classInput.size();i++){
					for(int j=0;j<divisionInput.get(i).size();j++){
						for(int k=0;k<batchInput.get(i).get(j).size();k++){
							if(batchInput.get(i).get(j).get(k).isFocusOwner()){
								if(batchInput.get(i).get(j).get(k).getText().equals("Enter Batch Name")){
									batchInput.get(i).get(j).get(k).setText("");
									batchInput.get(i).get(j).get(k).setForeground(new Color(0,128,255));
									batchInput.get(i).get(j).get(k).setFont(new Font("TimesRoman",Font.BOLD,25));
								}
								lastFocused = i;
								lastFocused1 = j;
								lastFocused2 = k;
							}
						}
					}
				}
			}
			public void focusLost(FocusEvent e){
				int i = lastFocused;
				int j = lastFocused1;
				int k = lastFocused2;
				if(batchInput.get(i).get(j).get(k).getText().equals("")){
					batchInput.get(i).get(j).get(k).setText("Enter Batch Name");
					batchInput.get(i).get(j).get(k).setForeground(new Color(102,178,255));
					batchInput.get(i).get(j).get(k).setFont(new Font("TimesRoman",Font.BOLD+Font.ITALIC,25));
				}
			}
		});
		batchInput.get(i).get(j).add(tempJTextField);
		batchInputPanel.get(i).get(j).get(batchInputPanel.get(i).get(j).size()-1).add(batchInput.get(i).get(j).get(batchInput.get(i).get(j).size()-1));
		
		if(batchInput.get(i).get(j).size()>1){
			JButton tempJButton = new JButton(i22);
			tempJButton.setOpaque(false);
			tempJButton.setContentAreaFilled(false);
			tempJButton.setBorderPainted(false);
			tempJButton.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
			if(batchInputCross.size()-1<i){
				for(int x=batchInputCross.size()-1;x<i;x++){
					batchInputCross.add(new ArrayList<ArrayList<JButton>>());
				}
			}
			if(batchInputCross.get(i).size()-1<j){
				for(int x=batchInputCross.get(i).size()-1;x<j;x++){
					batchInputCross.get(i).add(new ArrayList<JButton>());
				}
			}
			tempJButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					
					boolean done = false;
					
					for(int i=0;i<classInputPanel.size();i++){
						for(int j=0;j<divisionInputPanel.get(i).size();j++){
							for(int k=0;k<batchInputPanel.get(i).get(j).size();k++){
								try{
									if(batchInputCross.get(i).get(j).get(k).getModel().isArmed()){
										divisionInputPanel.get(i).get(j).remove(batchInputPanel.get(i).get(j).get(k));
										
										try{
											practicalSubjectTeacherChooseCross.get(i).get(j).remove(k);
										}catch(Exception e){}
										practicalSubjectTeacherChoose.get(i).get(j).remove(k);
										practicalSubjectTeacherChoosePanel.get(i).get(j).remove(k);
										practicalSubjectTeacherChooseAdd.get(i).get(j).remove(k);
										try{
											practicalSubjectChooseCross.get(i).get(j).remove(k);
										}catch(Exception e){}
										practicalSubjectChoose.get(i).get(j).remove(k);
										practicalSubjectChoosePanel.get(i).get(j).remove(k);
										practicalSubjectChooseAdd.get(i).get(j).remove(k);
										batchInput.get(i).get(j).remove(k);
										batchInputCross.get(i).get(j).remove(k);
										batchInputPanel.get(i).get(j).remove(k);
										
										done = true;
										break;
									}
								}catch(Exception e){}
							}
							if(done==true) { break; }
						}
						if(done==true) { break; }
					}
					
					RearrangeThirdEditPage();
				}
			});
			batchInputCross.get(i).get(j).add(tempJButton);
			batchInputPanel.get(i).get(j).get(batchInputPanel.get(i).get(j).size()-2).add(batchInputCross.get(i).get(j).get(batchInputCross.get(i).get(j).size()-1));
		}else{
			JButton tempJButton = new JButton(i23);
			tempJButton.setOpaque(false);
			tempJButton.setContentAreaFilled(false);
			tempJButton.setBorderPainted(false);
			tempJButton.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
			if(batchInputAdd.size()-1<i){
				for(int x=batchInputAdd.size()-1;x<i;x++){
					batchInputAdd.add(new ArrayList<JButton>());
				}
			}
			tempJButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					for(int i=0;i<classInputPanel.size();i++){
						for(int j=0;j<divisionInputPanel.get(i).size();j++){
							if(batchInputAdd.get(i).get(j).getModel().isArmed()){
								BatchInputAddFunction(i,j);
							}
						}
					}
				}
			});
			batchInputAdd.get(i).add(tempJButton);
		}
		batchInputPanel.get(i).get(j).get(batchInputPanel.get(i).get(j).size()-1).add(batchInputAdd.get(i).get(j));
		
		PracticalSubjectChooseAddFunction(i,j,batchInput.get(i).get(j).size()-1);
		
	}
	
	public void PracticalSubjectChooseAddFunction(int i,int j,int k){
		
		JPanel tempJPanel = new JPanel();
		tempJPanel.setOpaque(false);
		tempJPanel.setBorder(BorderFactory.createMatteBorder(1,0,1,0,new Color(102,178,255)));
		tempJPanel.setLayout(null);
		if(practicalSubjectChoosePanel.size()-1<i){
			for(int x=practicalSubjectChoosePanel.size()-1;x<i;x++){
				practicalSubjectChoosePanel.add(new ArrayList<ArrayList<ArrayList<JPanel>>>());
			}
		}
		if(practicalSubjectChoosePanel.get(i).size()-1<j){
			for(int x=practicalSubjectChoosePanel.get(i).size()-1;x<j;x++){
				practicalSubjectChoosePanel.get(i).add(new ArrayList<ArrayList<JPanel>>());
			}
		}
		if(practicalSubjectChoosePanel.get(i).get(j).size()-1<k){
			for(int x=practicalSubjectChoosePanel.get(i).get(j).size()-1;x<k;x++){
				practicalSubjectChoosePanel.get(i).get(j).add(new ArrayList<JPanel>());
			}
		}
		practicalSubjectChoosePanel.get(i).get(j).get(k).add(tempJPanel);
		batchInputPanel.get(i).get(j).get(k).add(practicalSubjectChoosePanel.get(i).get(j).get(k).get(practicalSubjectChoosePanel.get(i).get(j).get(k).size()-1));
		
		JComboBox tempJComboBox = new JComboBox();
		tempJComboBox = new JComboBox();
		tempJComboBox.setBackground(new Color(192,255,255));
		if(practicalSubjectChoose.size()-1<i){
			for(int x=practicalSubjectChoose.size()-1;x<i;x++){
				practicalSubjectChoose.add(new ArrayList<ArrayList<ArrayList<JComboBox>>>());
			}
		}
		if(practicalSubjectChoose.get(i).size()-1<j){
			for(int x=practicalSubjectChoose.get(i).size()-1;x<j;x++){
				practicalSubjectChoose.get(i).add(new ArrayList<ArrayList<JComboBox>>());
			}
		}
		if(practicalSubjectChoose.get(i).get(j).size()-1<k){
			for(int x=practicalSubjectChoose.get(i).get(j).size()-1;x<k;x++){
				practicalSubjectChoose.get(i).get(j).add(new ArrayList<JComboBox>());
			}
		}
		tempJComboBox.setForeground(new Color(102,178,255));
		tempJComboBox.setFont(new Font("TimesRoman",Font.BOLD+Font.ITALIC,25));
		DefaultListCellRenderer listRenderer = new DefaultListCellRenderer();
		listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		tempJComboBox.setRenderer(listRenderer);
		tempJComboBox.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e){
				for(int i=0;i<classInput.size();i++){
					for(int j=0;j<divisionInput.get(i).size();j++){
						for(int k=0;k<batchInput.get(i).get(j).size();k++){
							for(int l=0;l<practicalSubjectChoose.get(i).get(j).get(k).size();l++){
								if(practicalSubjectChoose.get(i).get(j).get(k).get(l).isFocusOwner()){
									if(practicalSubjectChoose.get(i).get(j).get(k).get(l).getSelectedItem().equals("Select Subject For Practical")||practicalSubjectChoose.get(i).get(j).get(k).get(l).getItemAt(0).equals("Select Subject For Practical")){
										practicalSubjectChoose.get(i).get(j).get(k).get(l).insertItemAt("- - - - - - - - - -",0);
										practicalSubjectChoose.get(i).get(j).get(k).get(l).removeItemAt(1);
										practicalSubjectChoose.get(i).get(j).get(k).get(l).setForeground(new Color(0,128,255));
										practicalSubjectChoose.get(i).get(j).get(k).get(l).setFont(new Font("TimesRoman",Font.BOLD,25));
									}
									lastFocused = i;
									lastFocused1 = j;
									lastFocused2 = k;
									lastFocused3 = l;
								}
							}
						}
					}
				}
			}
			public void focusLost(FocusEvent e){
				int i = lastFocused;
				int j = lastFocused1;
				int k = lastFocused2;
				int l = lastFocused3;
				if(practicalSubjectChoose.get(i).get(j).get(k).get(l).getSelectedItem().equals("- - - - - - - - - -")){
					practicalSubjectChoose.get(i).get(j).get(k).get(l).insertItemAt("Select Subject For Practical",0);
					practicalSubjectChoose.get(i).get(j).get(k).get(l).removeItemAt(1);
					practicalSubjectChoose.get(i).get(j).get(k).get(l).setForeground(new Color(102,178,255));
					practicalSubjectChoose.get(i).get(j).get(k).get(l).setFont(new Font("TimesRoman",Font.BOLD+Font.ITALIC,25));
				}
			}
		});
		practicalSubjectChoose.get(i).get(j).get(k).add(tempJComboBox);
		practicalSubjectChoosePanel.get(i).get(j).get(k).get(practicalSubjectChoosePanel.get(i).get(j).get(k).size()-1).add(practicalSubjectChoose.get(i).get(j).get(k).get(practicalSubjectChoose.get(i).get(j).get(k).size()-1));
		
		if(practicalSubjectChoose.get(i).get(j).get(k).size()>1){
			JButton tempJButton = new JButton(i22);
			tempJButton.setOpaque(false);
			tempJButton.setContentAreaFilled(false);
			tempJButton.setBorderPainted(false);
			tempJButton.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
			if(practicalSubjectChooseCross.size()-1<i){
				for(int x=practicalSubjectChooseCross.size()-1;x<i;x++){
					practicalSubjectChooseCross.add(new ArrayList<ArrayList<ArrayList<JButton>>>());
				}
			}
			if(practicalSubjectChooseCross.get(i).size()-1<j){
				for(int x=practicalSubjectChooseCross.get(i).size()-1;x<j;x++){
					practicalSubjectChooseCross.get(i).add(new ArrayList<ArrayList<JButton>>());
				}
			}
			if(practicalSubjectChooseCross.get(i).get(j).size()-1<k){
				for(int x=practicalSubjectChooseCross.get(i).get(j).size()-1;x<k;x++){
					practicalSubjectChooseCross.get(i).get(j).add(new ArrayList<JButton>());
				}
			}
			tempJButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					
					boolean done = false;
					
					for(int i=0;i<classInputPanel.size();i++){
						for(int j=0;j<divisionInputPanel.get(i).size();j++){
							for(int k=0;k<batchInputPanel.get(i).get(j).size();k++){
								for(int l=0;l<practicalSubjectChoosePanel.get(i).get(j).get(k).size();l++){
									try{
										if(practicalSubjectChooseCross.get(i).get(j).get(k).get(l).getModel().isArmed()){
											batchInputPanel.get(i).get(j).get(k).remove(practicalSubjectChoosePanel.get(i).get(j).get(k).get(l));
											
											try{
												practicalSubjectTeacherChooseCross.get(i).get(j).get(k).remove(l);
											}catch(Exception e){}
											practicalSubjectTeacherChoose.get(i).get(j).get(k).remove(l);
											practicalSubjectTeacherChoosePanel.get(i).get(j).get(k).remove(l);
											practicalSubjectTeacherChooseAdd.get(i).get(j).get(k).remove(l);
											practicalSubjectChoose.get(i).get(j).get(k).remove(l);
											practicalSubjectChooseCross.get(i).get(j).get(k).remove(l);
											practicalSubjectChoosePanel.get(i).get(j).get(k).remove(l);
											
											break;
										}
									}catch(Exception e){}
								}
								if(done==true) { break; }
							}
							if(done==true) { break; }
						}
						if(done==true) { break; }
					}
					
					RearrangeThirdEditPage();
				}
			});
			practicalSubjectChooseCross.get(i).get(j).get(k).add(tempJButton);
			practicalSubjectChoosePanel.get(i).get(j).get(k).get(practicalSubjectChoosePanel.get(i).get(j).get(k).size()-2).add(practicalSubjectChooseCross.get(i).get(j).get(k).get(practicalSubjectChooseCross.get(i).get(j).get(k).size()-1));
		}else{
			JButton tempJButton = new JButton(i23);
			tempJButton.setOpaque(false);
			tempJButton.setContentAreaFilled(false);
			tempJButton.setBorderPainted(false);
			tempJButton.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
			if(practicalSubjectChooseAdd.size()-1<i){
				for(int x=practicalSubjectChooseAdd.size()-1;x<i;x++){
					practicalSubjectChooseAdd.add(new ArrayList<ArrayList<JButton>>());
				}
			}
			if(practicalSubjectChooseAdd.get(i).size()-1<j){
				for(int x=practicalSubjectChooseAdd.get(i).size()-1;x<j;x++){
					practicalSubjectChooseAdd.get(i).add(new ArrayList<JButton>());
				}
			}
			tempJButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					for(int i=0;i<classInputPanel.size();i++){
						for(int j=0;j<divisionInputPanel.get(i).size();j++){
							for(int k=0;k<batchInputPanel.get(i).get(j).size();k++){
								if(practicalSubjectChooseAdd.get(i).get(j).get(k).getModel().isArmed()){
									PracticalSubjectChooseAddFunction(i,j,k);
								}
							}
						}
					}
				}
			});
			practicalSubjectChooseAdd.get(i).get(j).add(tempJButton);
		}
		practicalSubjectChoosePanel.get(i).get(j).get(k).get(practicalSubjectChoosePanel.get(i).get(j).get(k).size()-1).add(practicalSubjectChooseAdd.get(i).get(j).get(k));
		
		PracticalSubjectTeacherChooseAddFunction(i,j,k,practicalSubjectChoose.get(i).get(j).get(k).size()-1);
		
	}
	
	public void PracticalSubjectTeacherChooseAddFunction(int i,int j,int k,int l){
		
		JPanel tempJPanel = new JPanel();
		tempJPanel.setOpaque(false);
		tempJPanel.setBorder(BorderFactory.createMatteBorder(0,0,0,0,new Color(102,178,255)));
		tempJPanel.setLayout(null);
		if(practicalSubjectTeacherChoosePanel.size()-1<i){
			for(int x=practicalSubjectTeacherChoosePanel.size()-1;x<i;x++){
				practicalSubjectTeacherChoosePanel.add(new ArrayList<ArrayList<ArrayList<ArrayList<JPanel>>>>());
			}
		}
		if(practicalSubjectTeacherChoosePanel.get(i).size()-1<j){
			for(int x=practicalSubjectTeacherChoosePanel.get(i).size()-1;x<j;x++){
				practicalSubjectTeacherChoosePanel.get(i).add(new ArrayList<ArrayList<ArrayList<JPanel>>>());
			}
		}
		if(practicalSubjectTeacherChoosePanel.get(i).get(j).size()-1<k){
			for(int x=practicalSubjectTeacherChoosePanel.get(i).get(j).size()-1;x<k;x++){
				practicalSubjectTeacherChoosePanel.get(i).get(j).add(new ArrayList<ArrayList<JPanel>>());
			}
		}
		if(practicalSubjectTeacherChoosePanel.get(i).get(j).get(k).size()-1<l){
			for(int x=practicalSubjectTeacherChoosePanel.get(i).get(j).get(k).size()-1;x<l;x++){
				practicalSubjectTeacherChoosePanel.get(i).get(j).get(k).add(new ArrayList<JPanel>());
			}
		}
		practicalSubjectTeacherChoosePanel.get(i).get(j).get(k).get(l).add(tempJPanel);
		practicalSubjectChoosePanel.get(i).get(j).get(k).get(l).add(practicalSubjectTeacherChoosePanel.get(i).get(j).get(k).get(l).get(practicalSubjectTeacherChoosePanel.get(i).get(j).get(k).get(l).size()-1));
		
		JComboBox tempJComboBox = new JComboBox();
		tempJComboBox = new JComboBox();
		tempJComboBox.setBackground(new Color(192,255,255));
		if(practicalSubjectTeacherChoose.size()-1<i){
			for(int x=practicalSubjectTeacherChoose.size()-1;x<i;x++){
				practicalSubjectTeacherChoose.add(new ArrayList<ArrayList<ArrayList<ArrayList<JComboBox>>>>());
			}
		}
		if(practicalSubjectTeacherChoose.get(i).size()-1<j){
			for(int x=practicalSubjectTeacherChoose.get(i).size()-1;x<j;x++){
				practicalSubjectTeacherChoose.get(i).add(new ArrayList<ArrayList<ArrayList<JComboBox>>>());
			}
		}
		if(practicalSubjectTeacherChoose.get(i).get(j).size()-1<k){
			for(int x=practicalSubjectTeacherChoose.get(i).get(j).size()-1;x<k;x++){
				practicalSubjectTeacherChoose.get(i).get(j).add(new ArrayList<ArrayList<JComboBox>>());
			}
		}
		if(practicalSubjectTeacherChoose.get(i).get(j).get(k).size()-1<l){
			for(int x=practicalSubjectTeacherChoose.get(i).get(j).get(k).size()-1;x<l;x++){
				practicalSubjectTeacherChoose.get(i).get(j).get(k).add(new ArrayList<JComboBox>());
			}
		}
		tempJComboBox.setForeground(new Color(102,178,255));
		tempJComboBox.setFont(new Font("TimesRoman",Font.BOLD+Font.ITALIC,25));
		DefaultListCellRenderer listRenderer = new DefaultListCellRenderer();
		listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		tempJComboBox.setRenderer(listRenderer);
		tempJComboBox.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e){
				for(int i=0;i<classInput.size();i++){
					for(int j=0;j<divisionInput.get(i).size();j++){
						for(int k=0;k<batchInput.get(i).get(j).size();k++){
							for(int l=0;l<practicalSubjectChoose.get(i).get(j).get(k).size();l++){
								for(int m=0;m<practicalSubjectTeacherChoose.get(i).get(j).get(k).get(l).size();m++){
									if(practicalSubjectTeacherChoose.get(i).get(j).get(k).get(l).get(m).isFocusOwner()){
										if(practicalSubjectTeacherChoose.get(i).get(j).get(k).get(l).get(m).getSelectedItem().equals("Select Teacher For Practical")||practicalSubjectTeacherChoose.get(i).get(j).get(k).get(l).get(m).getItemAt(0).equals("Select Teacher For Practical")){
											practicalSubjectTeacherChoose.get(i).get(j).get(k).get(l).get(m).insertItemAt("- - - - - - - - - -",0);
											practicalSubjectTeacherChoose.get(i).get(j).get(k).get(l).get(m).removeItemAt(1);
											practicalSubjectTeacherChoose.get(i).get(j).get(k).get(l).get(m).setForeground(new Color(0,128,255));
											practicalSubjectTeacherChoose.get(i).get(j).get(k).get(l).get(m).setFont(new Font("TimesRoman",Font.BOLD,25));
										}
										lastFocused = i;
										lastFocused1 = j;
										lastFocused2 = k;
										lastFocused3 = l;
										lastFocused4 = m;
									}
								}
							}
						}
					}
				}
			}
			public void focusLost(FocusEvent e){
				int i = lastFocused;
				int j = lastFocused1;
				int k = lastFocused2;
				int l = lastFocused3;
				int m = lastFocused4;
				if(practicalSubjectTeacherChoose.get(i).get(j).get(k).get(l).get(m).getSelectedItem().equals("- - - - - - - - - -")){
					practicalSubjectTeacherChoose.get(i).get(j).get(k).get(l).get(m).insertItemAt("Select Teacher For Practical",0);
					practicalSubjectTeacherChoose.get(i).get(j).get(k).get(l).get(m).removeItemAt(1);
					practicalSubjectTeacherChoose.get(i).get(j).get(k).get(l).get(m).setForeground(new Color(102,178,255));
					practicalSubjectTeacherChoose.get(i).get(j).get(k).get(l).get(m).setFont(new Font("TimesRoman",Font.BOLD+Font.ITALIC,25));
				}
			}
		});
		practicalSubjectTeacherChoose.get(i).get(j).get(k).get(l).add(tempJComboBox);
		practicalSubjectTeacherChoosePanel.get(i).get(j).get(k).get(l).get(practicalSubjectTeacherChoosePanel.get(i).get(j).get(k).get(l).size()-1).add(practicalSubjectTeacherChoose.get(i).get(j).get(k).get(l).get(practicalSubjectTeacherChoose.get(i).get(j).get(k).get(l).size()-1));
		
		if(practicalSubjectTeacherChoose.get(i).get(j).get(k).get(l).size()>1){
			JButton tempJButton = new JButton(i22);
			tempJButton.setOpaque(false);
			tempJButton.setContentAreaFilled(false);
			tempJButton.setBorderPainted(false);
			tempJButton.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
			if(practicalSubjectTeacherChooseCross.size()-1<i){
				for(int x=practicalSubjectTeacherChooseCross.size()-1;x<i;x++){
					practicalSubjectTeacherChooseCross.add(new ArrayList<ArrayList<ArrayList<ArrayList<JButton>>>>());
				}
			}
			if(practicalSubjectTeacherChooseCross.get(i).size()-1<j){
				for(int x=practicalSubjectTeacherChooseCross.get(i).size()-1;x<j;x++){
					practicalSubjectTeacherChooseCross.get(i).add(new ArrayList<ArrayList<ArrayList<JButton>>>());
				}
			}
			if(practicalSubjectTeacherChooseCross.get(i).get(j).size()-1<k){
				for(int x=practicalSubjectTeacherChooseCross.get(i).get(j).size()-1;x<k;x++){
					practicalSubjectTeacherChooseCross.get(i).get(j).add(new ArrayList<ArrayList<JButton>>());
				}
			}
			if(practicalSubjectTeacherChooseCross.get(i).get(j).get(k).size()-1<l){
				for(int x=practicalSubjectTeacherChooseCross.get(i).get(j).get(k).size()-1;x<l;x++){
					practicalSubjectTeacherChooseCross.get(i).get(j).get(k).add(new ArrayList<JButton>());
				}
			}
			tempJButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					
					boolean done = false;
					
					for(int i=0;i<classInputPanel.size();i++){
						for(int j=0;j<divisionInputPanel.get(i).size();j++){
							for(int k=0;k<batchInputPanel.get(i).get(j).size();k++){
								for(int l=0;l<practicalSubjectChoosePanel.get(i).get(j).get(k).size();l++){
									for(int m=0;m<practicalSubjectTeacherChoosePanel.get(i).get(j).get(k).get(l).size();m++){
										try{
											if(practicalSubjectTeacherChooseCross.get(i).get(j).get(k).get(l).get(m).getModel().isArmed()){
												practicalSubjectChoosePanel.get(i).get(j).get(k).get(l).remove(practicalSubjectTeacherChoosePanel.get(i).get(j).get(k).get(l).get(m));
												
												practicalSubjectTeacherChooseCross.get(i).get(j).get(k).get(l).remove(m);
												practicalSubjectTeacherChoose.get(i).get(j).get(k).get(l).remove(m);
												practicalSubjectTeacherChoosePanel.get(i).get(j).get(k).get(l).remove(m);
												
												break;
											}
										}catch(Exception e){}
									}
									if(done==true) { break; }
								}
								if(done==true) { break; }
							}
							if(done==true) { break; }
						}
						if(done==true) { break; }
					}
					
					RearrangeThirdEditPage();
				}
			});
			practicalSubjectTeacherChooseCross.get(i).get(j).get(k).get(l).add(tempJButton);
			practicalSubjectTeacherChoosePanel.get(i).get(j).get(k).get(l).get(practicalSubjectTeacherChoosePanel.get(i).get(j).get(k).get(l).size()-2).add(practicalSubjectTeacherChooseCross.get(i).get(j).get(k).get(l).get(practicalSubjectTeacherChooseCross.get(i).get(j).get(k).get(l).size()-1));
		}else{
			JButton tempJButton = new JButton(i23);
			tempJButton.setOpaque(false);
			tempJButton.setContentAreaFilled(false);
			tempJButton.setBorderPainted(false);
			tempJButton.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
			if(practicalSubjectTeacherChooseAdd.size()-1<i){
				for(int x=practicalSubjectTeacherChooseAdd.size()-1;x<i;x++){
					practicalSubjectTeacherChooseAdd.add(new ArrayList<ArrayList<ArrayList<JButton>>>());
				}
			}
			if(practicalSubjectTeacherChooseAdd.get(i).size()-1<j){
				for(int x=practicalSubjectTeacherChooseAdd.get(i).size()-1;x<j;x++){
					practicalSubjectTeacherChooseAdd.get(i).add(new ArrayList<ArrayList<JButton>>());
				}
			}
			if(practicalSubjectTeacherChooseAdd.get(i).get(j).size()-1<k){
				for(int x=practicalSubjectTeacherChooseAdd.get(i).get(j).size()-1;x<k;x++){
					practicalSubjectTeacherChooseAdd.get(i).get(j).add(new ArrayList<JButton>());
				}
			}
			tempJButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					for(int i=0;i<classInputPanel.size();i++){
						for(int j=0;j<divisionInputPanel.get(i).size();j++){
							for(int k=0;k<batchInputPanel.get(i).get(j).size();k++){
								for(int l=0;l<practicalSubjectChoosePanel.get(i).get(j).get(k).size();l++){
									if(practicalSubjectTeacherChooseAdd.get(i).get(j).get(k).get(l).getModel().isArmed()){
										PracticalSubjectTeacherChooseAddFunction(i,j,k,l);
									}
								}
							}
						}
					}
				}
			});
			practicalSubjectTeacherChooseAdd.get(i).get(j).get(k).add(tempJButton);
		}
		practicalSubjectTeacherChoosePanel.get(i).get(j).get(k).get(l).get(practicalSubjectTeacherChoosePanel.get(i).get(j).get(k).get(l).size()-1).add(practicalSubjectTeacherChooseAdd.get(i).get(j).get(k).get(l));
		
		RearrangeThirdEditPage();
		
	}
	
	public void RearrangeThirdEditPage(){
		
		int Size5 = (654/2)-37;
		
		for(int i=0;i<classInputPanel.size();i++){
			
			int Size4 = 0;
		
			for(int j=0;j<divisionInputPanel.get(i).size();j++){
				
				int Size3 = 0;
				
				for(int k=0;k<batchInputPanel.get(i).get(j).size();k++){
					
					int Size2 = 0;
					
					for(int l=0;l<practicalSubjectChoosePanel.get(i).get(j).get(k).size();l++){
						
						int Size1 = 0;
						
						for(int m=0;m<practicalSubjectTeacherChoosePanel.get(i).get(j).get(k).get(l).size();m++){
							
							practicalSubjectTeacherChoosePanel.get(i).get(j).get(k).get(l).get(m).setBounds(770,(m*54)+10,535,54);
							practicalSubjectTeacherChoose.get(i).get(j).get(k).get(l).get(m).setBounds(0,10,495,34);
							if(m!=practicalSubjectTeacherChoosePanel.get(i).get(j).get(k).get(l).size()-1){
								practicalSubjectTeacherChooseCross.get(i).get(j).get(k).get(l).get(m).setBounds(500,10,i22.getIconWidth(),i22.getIconHeight());
							}else{
								practicalSubjectTeacherChooseAdd.get(i).get(j).get(k).get(l).setBounds(500,10,i23.getIconWidth(),i23.getIconHeight());
							}
							Size1 = (m*54)+54+20;
							
						}
						
						practicalSubjectChoosePanel.get(i).get(j).get(k).get(l).setBounds(770,Size2,1305,Size1);
						int Y = (Size1/2)-17;
						practicalSubjectChoose.get(i).get(j).get(k).get(l).setBounds(0,Y,495,34);
						if(l!=practicalSubjectChoosePanel.get(i).get(j).get(k).size()-1){
							practicalSubjectChooseCross.get(i).get(j).get(k).get(l).setBounds(500,Y,i22.getIconWidth(),i22.getIconHeight());
						}else{
							practicalSubjectChooseAdd.get(i).get(j).get(k).setBounds(500,Y,i23.getIconWidth(),i23.getIconHeight());
						}
						Size2 = Size2 + Size1;
						
					}
					
					batchInputPanel.get(i).get(j).get(k).setBounds(770,Size3,2075,Size2);
					int Y = (Size2/2)-17;
					batchInput.get(i).get(j).get(k).setBounds(0,Y,495,34);
					if(k!=batchInputPanel.get(i).get(j).size()-1){
						batchInputCross.get(i).get(j).get(k).setBounds(500,Y,i22.getIconWidth(),i22.getIconHeight());
					}else{
						batchInputAdd.get(i).get(j).setBounds(500,Y,i23.getIconWidth(),i23.getIconHeight());
					}
					Size3 = Size3 + Size2;
					
				}
				
				divisionInputPanel.get(i).get(j).setBounds(770,Size4,2845,Size3);
				int Y = (Size3/2)-17;
				divisionInput.get(i).get(j).setBounds(0,Y,495,34);
				if(j!=divisionInputPanel.get(i).size()-1){
					divisionInputCross.get(i).get(j).setBounds(500,Y,i22.getIconWidth(),i22.getIconHeight());
				}else{
					divisionInputAdd.get(i).setBounds(500,Y,i23.getIconWidth(),i23.getIconHeight());
				}
				Size4 = Size4 + Size3;
				
			}
			
			classInputPanel.get(i).setBounds(235,Size5,3615,Size4);
			int Y = (Size4/2)-17;
			classInput.get(i).setBounds(0,Y,495,34);
			if(i!=classInputPanel.size()-1){
				classInputCross.get(i).setBounds(500,Y,i22.getIconWidth(),i22.getIconHeight());
			}else{
				classInputAdd.setBounds(500,Y,i23.getIconWidth(),i23.getIconHeight());
			}
			Size5 = Size5 + Size4;
			
			if(i==0&&i==classInputPanel.size()-1){
				classInputPanel.get(i).setBorder(BorderFactory.createMatteBorder(5,0,5,0,new Color(102,178,255)));
			}else if(i==0){
				classInputPanel.get(i).setBorder(BorderFactory.createMatteBorder(5,0,1,0,new Color(102,178,255)));
			}else if(i==classInputPanel.size()-1){
				classInputPanel.get(i).setBorder(BorderFactory.createMatteBorder(1,0,5,0,new Color(102,178,255)));
			}else{
				classInputPanel.get(i).setBorder(BorderFactory.createMatteBorder(1,0,1,0,new Color(102,178,255)));
			}
			
		}
		
		int Y = (classInputPanel.get(classInputPanel.size()-1).getY() + classInputPanel.get(classInputPanel.size()-1).getHeight())-lastThirdEditPanelSize;
		ep[2].setBounds(ep[2].getX(),ep[2].getY()-Y,ep[2].getWidth(),ep[2].getHeight()+Y);
		if(ep[2].getY()>0){
			ep[2].setBounds(ep[2].getX(),0,ep[2].getWidth(),ep[2].getHeight());
		}else if(ep[2].getY()<(654-ep[2].getHeight())){
			ep[2].setBounds(ep[2].getX(),654-ep[2].getHeight(),ep[2].getWidth(),ep[2].getHeight());
		}
		lastThirdEditPanelSize = classInputPanel.get(classInputPanel.size()-1).getY() + classInputPanel.get(classInputPanel.size()-1).getHeight();
		
		SortFirstEditPage();
		SetEditPanelValue(2);
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////
	
	public void LastPage(){
		
		TTMainPanel = new JPanel();
		TTMainPanel.setBounds(0,0,1366,768);
		TTMainPanel.setBorder(new LineBorder(Color.black,1));
		TTMainPanel.setLayout(null);
		TTMainPanel.setVisible(false);
		f.add(TTMainPanel);
		
		TTLeftSideButtonIcon = new ImageIcon("IconsTimeTable\\leftsidebutton.png");
		TTLeftSideButtonIcon = new ImageIcon(TTLeftSideButtonIcon.getImage().getScaledInstance(25,566,java.awt.Image.SCALE_SMOOTH));
		TTLeftSideButton = new JButton(TTLeftSideButtonIcon);
		TTLeftSideButton.setBounds(0,70,TTLeftSideButtonIcon.getIconWidth(),TTLeftSideButtonIcon.getIconHeight());
		TTLeftSideButton.setOpaque(false);
		TTLeftSideButton.setContentAreaFilled(false);
		TTLeftSideButton.setBorderPainted(false);
		TTLeftSideButton.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
		TTLeftSideButton.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				
			}
		});
		TTMainPanel.add(TTLeftSideButton);
		
		TTRightSideButtonIcon = new ImageIcon("IconsTimeTable\\rightsidebutton.png");
		TTRightSideButtonIcon = new ImageIcon(TTRightSideButtonIcon.getImage().getScaledInstance(25,566,java.awt.Image.SCALE_SMOOTH));
		TTRightSideButton = new JButton(TTRightSideButtonIcon);
		TTRightSideButton.setBounds(1341,70,TTRightSideButtonIcon.getIconWidth(),TTRightSideButtonIcon.getIconHeight());
		TTRightSideButton.setOpaque(false);
		TTRightSideButton.setContentAreaFilled(false);
		TTRightSideButton.setBorderPainted(false);
		TTRightSideButton.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
		TTRightSideButton.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				TTRightSideButton.setVisible(false);
				TTRightSidePanel.setVisible(true);
			}
		});
		TTMainPanel.add(TTRightSideButton);
		
		TTRightSidePanel = new JPanel();
		TTRightSidePanel.setBounds(1170,70,196,566);
		TTRightSidePanel.setOpaque(false);
		TTRightSidePanel.setLayout(null);
		TTRightSidePanel.setVisible(false);
		TTRightSidePanel.addMouseListener(new MouseAdapter(){
			public void mouseExited(MouseEvent e){
				TTRightSidePanel.setVisible(false);
				TTRightSideButton.setVisible(true);
			}
		});
		TTMainPanel.add(TTRightSidePanel);
		
		TTHomeIcon = new ImageIcon("IconsTimeTable\\home_key.png");
		TTHomeIcon = new ImageIcon(TTHomeIcon.getImage().getScaledInstance(150,150,java.awt.Image.SCALE_SMOOTH));
		TTHomeButton = new JLabel(TTHomeIcon);
		TTHomeButton.setBounds(36,36,TTHomeIcon.getIconWidth(),TTHomeIcon.getIconHeight());
		TTHomeButton.setOpaque(false);
		TTHomeButton.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
		TTHomeButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				TTRightSidePanel.setVisible(false);
				TTRightSideButton.setVisible(true);
				confirmfBy = "home";
				confirmf.setVisible(true);
				f.setEnabled(false);
			}
			public void mouseEntered(MouseEvent e){
				TTRightSideButton.setVisible(false);
				TTRightSidePanel.setVisible(true);
			}
		});
		TTRightSidePanel.add(TTHomeButton);
		
		TTSaveIcon = new ImageIcon("IconsTimeTable\\save_key.png");
		TTSaveIcon = new ImageIcon(TTSaveIcon.getImage().getScaledInstance(150,150,java.awt.Image.SCALE_SMOOTH));
		TTSaveButton = new JLabel(TTSaveIcon);
		TTSaveButton.setBounds(36,208,TTSaveIcon.getIconWidth(),TTSaveIcon.getIconHeight());
		TTSaveButton.setOpaque(false);
		TTSaveButton.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
		TTSaveButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				TTRightSidePanel.setVisible(false);
				TTRightSideButton.setVisible(true);
				//l8.setText("Successfully Saved !");
				//l8.setFont(new Font("TimesRoman",Font.BOLD,60));
				//informf.setVisible(true);
				//f.setEnabled(false);
			}
			public void mouseEntered(MouseEvent e){
				TTRightSideButton.setVisible(false);
				TTRightSidePanel.setVisible(true);
			}
		});
		TTRightSidePanel.add(TTSaveButton);
		
		TTEditIcon = new ImageIcon("IconsTimeTable\\edit1_key.png");
		TTEditIcon = new ImageIcon(TTEditIcon.getImage().getScaledInstance(150,150,java.awt.Image.SCALE_SMOOTH));
		TTEditButton = new JLabel(TTEditIcon);
		TTEditButton.setBounds(36,380,TTEditIcon.getIconWidth(),TTEditIcon.getIconHeight());
		TTEditButton.setOpaque(false);
		TTEditButton.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
		TTEditButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				TTRightSidePanel.setVisible(false);
				TTRightSideButton.setVisible(true);
				TTMainPanel.setVisible(false);
				p4.setVisible(true);
			}
			public void mouseEntered(MouseEvent e){
				TTRightSideButton.setVisible(false);
				TTRightSidePanel.setVisible(true);
			}
		});
		TTRightSidePanel.add(TTEditButton);
		
		TTRightSidePanelIcon = new ImageIcon("IconsTimeTable\\right_glass_background.png");
		TTRightSidePanelIcon = new ImageIcon(TTRightSidePanelIcon.getImage().getScaledInstance(196,566,java.awt.Image.SCALE_SMOOTH));
		TTRightSidePanelBackground = new JLabel(TTRightSidePanelIcon);
		TTRightSidePanelBackground.setBounds(0,0,196,566);
		TTRightSidePanel.add(TTRightSidePanelBackground);
		
		TTBackArrowIcon = new ImageIcon("IconsTimeTable\\back_arrow.png");
		TTBackArrowIcon = new ImageIcon(TTBackArrowIcon.getImage().getScaledInstance(100,100,java.awt.Image.SCALE_SMOOTH));
		TTBackArrow = new JButton(TTBackArrowIcon);
		TTBackArrow.setBounds(35,35,TTBackArrowIcon.getIconWidth(),TTBackArrowIcon.getIconHeight());
		TTBackArrow.setOpaque(false);
		TTBackArrow.setContentAreaFilled(false);
		TTBackArrow.setBorderPainted(false);
		TTBackArrow.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
		TTBackArrow.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				boolean done = false;
				for(int i=0;i<classInput.size();i++){
					for(int j=0;j<divisionInput.get(i).size();j++){
						try{
							if(TTPanel.get(i).get(j).isVisible()){
								if(j!=0){
									TTPanel.get(i).get(j).setVisible(false);
									TTPanel.get(i).get(j-1).setVisible(true);
								}else{
									try{
										TTPanel.get(i-1).get(TTPanel.get(i-1).size()-1).setVisible(true);
										TTPanel.get(i).get(j).setVisible(false);
									}catch(Exception evt){}
								}
								done = true;
								break;
							}
							if(done){ break; }
						}catch(Exception evt){}
					}
					if(done){ break; }
				}
			}
		});
		TTMainPanel.add(TTBackArrow);
		
		TTNextArrowIcon = new ImageIcon("IconsTimeTable\\next_arrow.png");
		TTNextArrowIcon = new ImageIcon(TTNextArrowIcon.getImage().getScaledInstance(100,100,java.awt.Image.SCALE_SMOOTH));
		TTNextArrow = new JButton(TTNextArrowIcon);
		TTNextArrow.setBounds(1231,35,TTNextArrowIcon.getIconWidth(),TTNextArrowIcon.getIconHeight());
		TTNextArrow.setOpaque(false);
		TTNextArrow.setContentAreaFilled(false);
		TTNextArrow.setBorderPainted(false);
		TTNextArrow.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
		TTNextArrow.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				boolean done = false;
				for(int i=0;i<classInput.size();i++){
					for(int j=0;j<divisionInput.get(i).size();j++){
						try{
							if(TTPanel.get(i).get(j).isVisible()){
								if(j!=divisionInput.get(i).size()-1){
									TTPanel.get(i).get(j).setVisible(false);
									TTPanel.get(i).get(j+1).setVisible(true);
								}else{
									try{
										TTPanel.get(i+1).get(0).setVisible(true);
										TTPanel.get(i).get(j).setVisible(false);
									}catch(Exception evt){}
								}
								done = true;
								break;
							}
							if(done){ break; }
						}catch(Exception evt){}
					}
					if(done){ break; }
				}
			}
		});
		TTMainPanel.add(TTNextArrow);
		
		TTCoverPanel = new JPanel();
		TTCoverPanel.setBounds(0,0,1366,768);
		TTCoverPanel.setOpaque(false);
		TTCoverPanel.setLayout(null);
		TTCoverPanel.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				TTRightSidePanel.setVisible(false);
				TTRightSideButton.setVisible(true);
				TTCoverPanel.requestFocusInWindow();
			}
		});
		TTCoverPanel.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent e){
				int key = e.getKeyCode();
				if(key == KeyEvent.VK_UP){
					
				}else if(key == KeyEvent.VK_DOWN){
					
				}else if(key == KeyEvent.VK_LEFT){
					boolean done = false;
					for(int i=0;i<classInput.size();i++){
						for(int j=0;j<divisionInput.get(i).size();j++){
							try{
								if(TTPanel.get(i).get(j).isVisible()){
									if(j!=0){
										TTPanel.get(i).get(j).setVisible(false);
										TTPanel.get(i).get(j-1).setVisible(true);
									}else{
										try{
											TTPanel.get(i-1).get(TTPanel.get(i-1).size()-1).setVisible(true);
											TTPanel.get(i).get(j).setVisible(false);
										}catch(Exception evt){}
									}
									done = true;
									break;
								}
								if(done){ break; }
							}catch(Exception evt){}
						}
						if(done){ break; }
					}
				}else if(key == KeyEvent.VK_RIGHT){
					boolean done = false;
					for(int i=0;i<classInput.size();i++){
						for(int j=0;j<divisionInput.get(i).size();j++){
							try{
								if(TTPanel.get(i).get(j).isVisible()){
									if(j!=divisionInput.get(i).size()-1){
										TTPanel.get(i).get(j).setVisible(false);
										TTPanel.get(i).get(j+1).setVisible(true);
									}else{
										try{
											TTPanel.get(i+1).get(0).setVisible(true);
											TTPanel.get(i).get(j).setVisible(false);
										}catch(Exception evt){}
									}
									done = true;
									break;
								}
								if(done){ break; }
							}catch(Exception evt){}
						}
						if(done){ break; }
					}
				}
			}
			public void keyTyped(KeyEvent e){}
			public void keyReleased(KeyEvent e){}
		});
		TTCoverPanel.addMouseWheelListener(new MouseWheelListener(){
			public void mouseWheelMoved(MouseWheelEvent e){
				for(int i=0;i<classInput.size();i++){
					for(int j=0;j<divisionInput.get(i).size();j++){
						if(TTPanel.get(i).get(j).isVisible()){
							int notches = e.getWheelRotation();
							if(notches<0){
								if(TTPanel.get(i).get(j).getY()<=-25){
									if(TTPanel.get(i).get(j).getY()<0){ TTPanel.get(i).get(j).setBounds(TTPanel.get(i).get(j).getX(),TTPanel.get(i).get(j).getY()+25,TTPanel.get(i).get(j).getWidth(),TTPanel.get(i).get(j).getHeight()); }
								}else{
									if(TTPanel.get(i).get(j).getY()<0){ TTPanel.get(i).get(j).setBounds(TTPanel.get(i).get(j).getX(),0,TTPanel.get(i).get(j).getWidth(),TTPanel.get(i).get(j).getHeight()); }
								}
							}else{
								if(TTPanel.get(i).get(j).getY()-(604-TTPanel.get(i).get(j).getHeight())>25){
									if(TTPanel.get(i).get(j).getY()>(604-TTPanel.get(i).get(j).getHeight())){ TTPanel.get(i).get(j).setBounds(TTPanel.get(i).get(j).getX(),TTPanel.get(i).get(j).getY()-25,TTPanel.get(i).get(j).getWidth(),TTPanel.get(i).get(j).getHeight()); }
								}else{
									if(TTPanel.get(i).get(j).getY()>(604-TTPanel.get(i).get(j).getHeight())){ TTPanel.get(i).get(j).setBounds(TTPanel.get(i).get(j).getX(),604-TTPanel.get(i).get(j).getHeight(),TTPanel.get(i).get(j).getWidth(),TTPanel.get(i).get(j).getHeight()); }
								}
							}
						}
					}
				}
			}
		});
		TTMainPanel.add(TTCoverPanel);
		
		TTBackPanel = new JPanel();
		TTBackPanel.setBounds(35,35,1296,604);
		TTBackPanel.setOpaque(false);
		TTBackPanel.setLayout(null);
		TTMainPanel.add(TTBackPanel);
		
		TTMainPanelBackground = new JLabel(i5);
		TTMainPanelBackground.setBounds(0,0,1366,768);
		TTMainPanel.add(TTMainPanelBackground);
		
	}
	
	public void PutTT(){
		
		for(int i=0;i<TTPanel.size();i++){
			for(int j=0;j<TTPanel.get(i).size();j++){
				TTBackPanel.remove(TTPanel.get(i).get(j));
			}
		}
		TTHeading.clear();
		TTTime.clear();
		TTDay.clear();
		TTPanel.clear();
		
		for(int i=0;i<classInput.size();i++){
			for(int j=0;j<divisionInput.get(i).size();j++){
				
				JPanel tempJPanel = new JPanel();
				tempJPanel.setBounds(0,0,1296,604);
				tempJPanel.setOpaque(false);
				tempJPanel.setLayout(null);
				if(TTPanel.size()-1<i){
					for(int x=TTPanel.size()-1;x<i;x++){
						TTPanel.add(new ArrayList<JPanel>());
					}
				}
				tempJPanel.setVisible(false);
				TTPanel.get(i).add(tempJPanel);
				TTBackPanel.add(TTPanel.get(i).get(TTPanel.get(i).size()-1));
				
				JTextField tempJTextField1 = new JTextField(classInput.get(i).getText()+" : "+divisionInput.get(i).get(j).getText());
				tempJTextField1.setBounds(0,0,1296,100);
				tempJTextField1.setForeground(new Color(0,128,255));
				tempJTextField1.setBackground(new Color(204,255,255));
				tempJTextField1.setFont(new Font("TimesRoman",Font.BOLD,50));
				tempJTextField1.setBorder(BorderFactory.createMatteBorder(3,3,3,3,new Color(255,153,153)));
				tempJTextField1.setHorizontalAlignment(JTextField.CENTER);
				if(TTHeading.size()-1<i){
					for(int x=TTHeading.size()-1;x<i;x++){
						TTHeading.add(new ArrayList<JTextField>());
					}
				}
				tempJTextField1.setEditable(false);
				TTHeading.get(i).add(tempJTextField1);
				TTPanel.get(i).get(j).add(TTHeading.get(i).get(TTHeading.get(i).size()-1));
				
				for(int k=0;k<7;k++){
					
					JTextField tempJTextField = new JTextField();
					if(k==0){
						tempJTextField.setText("Time\\Day");
						tempJTextField.setBounds(0,120,146,100);
					}else if(k==1){
						tempJTextField.setText("Monday");
						tempJTextField.setBounds(156,120,190,100);
					}else if(k==2){
						tempJTextField.setText("Tuesday");
						tempJTextField.setBounds(346,120,190,100);
					}else if(k==3){
						tempJTextField.setText("Wednesday");
						tempJTextField.setBounds(536,120,190,100);
					}else if(k==4){
						tempJTextField.setText("Thursday");
						tempJTextField.setBounds(726,120,190,100);
					}else if(k==5){
						tempJTextField.setText("Friday");
						tempJTextField.setBounds(916,120,190,100);
					}else if(k==6){
						tempJTextField.setText("Saturday");
						tempJTextField.setBounds(1106,120,190,100);
					}
					tempJTextField.setForeground(new Color(255,153,153));
					tempJTextField.setBackground(new Color(204,255,255));
					tempJTextField.setFont(new Font("TimesRoman",Font.BOLD,30));
					tempJTextField.setBorder(BorderFactory.createMatteBorder(3,3,3,3,new Color(255,153,153)));
					tempJTextField.setHorizontalAlignment(JTextField.CENTER);
					if(TTDay.size()-1<i){
						for(int x=TTDay.size()-1;x<i;x++){
							TTDay.add(new ArrayList<ArrayList<JTextField>>());
						}
					}
					if(TTDay.get(i).size()-1<j){
						for(int x=TTDay.get(i).size()-1;x<j;x++){
							TTDay.get(i).add(new ArrayList<JTextField>());
						}
					}
					tempJTextField.setEditable(false);
					TTDay.get(i).get(j).add(tempJTextField);
					TTPanel.get(i).get(j).add(TTDay.get(i).get(j).get(TTDay.get(i).get(j).size()-1));
					
				}
				
			}
		}
		
		TTPanel.get(0).get(0).setVisible(true);
		
		ScheduleTT();
		
	}
	
	public void ScheduleTT(){
		
		for(int i=0;i<classInput.size();i++){
			for(int j=0;j<divisionInput.get(i).size();j++){
				
				int size = ((batchInput.get(i).get(j).size()*27)+10)/2;
				if(size<59){ size = 59; }
				for(int k=0;k<6;k++){
					
					JTextField tempJTextField = new JTextField();
					if(k==0){
						tempJTextField.setText("09:00-10:00");
						tempJTextField.setBounds(0,230,146,size);
					}else if(k==1){
						tempJTextField.setText("10:00-11:00");
						tempJTextField.setBounds(0,TTTime.get(i).get(j).get(0).getY()+size,146,size);
					}else if(k==2){
						tempJTextField.setText("11:15-12:15");
						tempJTextField.setBounds(0,TTTime.get(i).get(j).get(1).getY()+size+10,146,size);
					}else if(k==3){
						tempJTextField.setText("12:15-01:15");
						tempJTextField.setBounds(0,TTTime.get(i).get(j).get(2).getY()+size,146,size);
					}else if(k==4){
						tempJTextField.setText("02:15-03:15");
						tempJTextField.setBounds(0,TTTime.get(i).get(j).get(3).getY()+size+10,146,size);
					}else if(k==5){
						tempJTextField.setText("03:15-04:15");
						tempJTextField.setBounds(0,TTTime.get(i).get(j).get(4).getY()+size,146,size);
					}
					tempJTextField.setForeground(new Color(255,153,153));
					tempJTextField.setBackground(new Color(204,255,255));
					tempJTextField.setFont(new Font("TimesRoman",Font.BOLD,20));
					tempJTextField.setBorder(BorderFactory.createMatteBorder(3,3,3,3,new Color(255,153,153)));
					tempJTextField.setHorizontalAlignment(JTextField.CENTER);
					if(TTTime.size()-1<i){
						for(int x=TTTime.size()-1;x<i;x++){
							TTTime.add(new ArrayList<ArrayList<JTextField>>());
						}
					}
					if(TTTime.get(i).size()-1<j){
						for(int x=TTTime.get(i).size()-1;x<j;x++){
							TTTime.get(i).add(new ArrayList<JTextField>());
						}
					}
					tempJTextField.setEditable(false);
					TTTime.get(i).get(j).add(tempJTextField);
					TTPanel.get(i).get(j).add(TTTime.get(i).get(j).get(TTTime.get(i).get(j).size()-1));
					
				}
				TTPanel.get(i).get(j).setBounds(TTPanel.get(i).get(j).getX(),TTPanel.get(i).get(j).getY(),TTPanel.get(i).get(j).getWidth(),TTTime.get(i).get(j).get(TTTime.get(i).get(j).size()-1).getY()+size);
				
			}
		}
		
		Random random = new Random();
		boolean PutTTAgain = true;
		try{
			
			while(PutTTAgain){
				
				PutTTAgain = false;
				
				for(int i=0;i<classInput.size();i++){
					for(int j=0;j<divisionInput.get(i).size();j++){
						Component[] component4 = TTPanel.get(i).get(j).getComponents();
						for(int z=0;z<component4.length;z++){
							if(component4[z].getX()>=TTDay.get(i).get(j).get(1).getX() && component4[z].getY()>=TTTime.get(i).get(j).get(0).getY()){
								TTPanel.get(i).get(j).remove(component4[z]);
							}
						}
					}
				}
				
				ArrayList<ArrayList<ArrayList<Integer>>> remainingLecture = new ArrayList<ArrayList<ArrayList<Integer>>>();
				for(int i=0;i<classInput.size();i++){
					remainingLecture.add(new ArrayList<ArrayList<Integer>>());
					for(int j=0;j<divisionInput.get(i).size();j++){
						remainingLecture.get(i).add(new ArrayList<Integer>());
						for(int k=0;k<subjectChoose.get(i).get(j).size();k++){
							for(int x=0;x<subjectNameInput.size();x++){
								if(subjectNameInput.get(x).getText().equals(subjectChoose.get(i).get(j).get(k).getSelectedItem())){
									remainingLecture.get(i).get(j).add(Integer.parseInt(lecturePerWeek.get(x).getText()));
								}
							}
						}
					}
				}
				
				ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>> remainingPractical = new ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>>();
				for(int i=0;i<classInput.size();i++){
					remainingPractical.add(new ArrayList<ArrayList<ArrayList<Integer>>>());
					for(int j=0;j<divisionInput.get(i).size();j++){
						remainingPractical.get(i).add(new ArrayList<ArrayList<Integer>>());
						for(int k=0;k<batchInput.get(i).get(j).size();k++){
							remainingPractical.get(i).get(j).add(new ArrayList<Integer>());
							for(int l=0;l<practicalSubjectChoose.get(i).get(j).get(k).size();l++){
								for(int x=0;x<subjectNameInput.size();x++){
									if(subjectNameInput.get(x).getText().equals(practicalSubjectChoose.get(i).get(j).get(k).get(l).getSelectedItem())){
										remainingPractical.get(i).get(j).get(k).add(Integer.parseInt(practicalPerWeek.get(x).getText()));
									}
								}
							}
						}
					}
				}
				
				for(int i=0;i<classInput.size();i++){
					for(int j=0;j<divisionInput.get(i).size();j++){
						
						////////////////////////////// For Practical Schedule ///////////////////////////
						if(!(batchInput.get(i).get(j).size()==1 && batchInput.get(i).get(j).get(0).getText().equals("Enter Batch Name") && practicalSubjectChoose.get(i).get(j).get(0).size()==1 && practicalSubjectChoose.get(i).get(j).get(0).get(0).getSelectedItem().equals("Select Subject For Practical") && practicalSubjectTeacherChoose.get(i).get(j).get(0).get(0).size()==1 && practicalSubjectTeacherChoose.get(i).get(j).get(0).get(0).get(0).getSelectedItem().equals("Select Teacher For Practical"))){
						
							JPanel tempJPanel[] = new JPanel[1000];
							for(int x=0;x<1000;x++){
								tempJPanel[x] = new JPanel();
								tempJPanel[x].setBounds(0,0,1296,604);
								tempJPanel[x].setOpaque(false);
								tempJPanel[x].setLayout(null);
								tempJPanel[x].setVisible(false);
							}
							
							int counter2 = 0;
							boolean perfectPractical = false;
							while(!perfectPractical){
								
								perfectPractical = true;
								
								int dayNumberArray[] = new int[6];
								for(int x=0;x<6;x++){
									dayNumberArray[x] = 0;
								}
								boolean done = false;
								while(!done){
									
									int randomValue = random.nextInt(3);
									ArrayList<Integer> dayNumberCntArray = new ArrayList<Integer>();
									for(int x=0;x<6;x++){
										if(dayNumberArray[x] == 0){ dayNumberCntArray.add(x); }
									}
									if(dayNumberCntArray.size() == 0){
										for(int x=0;x<6;x++){
											dayNumberArray[x] = 0;
											dayNumberCntArray.add(x);
										}
									}
									int dayNumber = dayNumberCntArray.get(random.nextInt(dayNumberCntArray.size()));
									
									boolean allowed3 = true;
									Component[] component = TTPanel.get(i).get(j).getComponents();
									for(int x=0;x<component.length;x++){
										if(component[x].getX()==TTDay.get(i).get(j).get(dayNumber+1).getX() && component[x].getY()==TTTime.get(i).get(j).get(randomValue*2).getY()){
											allowed3 = false;
										}
									}
									
									if(allowed3 && (randomValue!=2||dayNumber!=5)){
										
										dayNumberArray[dayNumber] = 1;
										
										String allotedSubject[] = new String[batchInput.get(i).get(j).size()];
										for(int k=0;k<batchInput.get(i).get(j).size();k++){
											allotedSubject[k] = "";
										}
										
										boolean done2 = false;
										while(!done2){
											
											boolean allowed2 = false;
											ArrayList<Integer> remSubjectCnt = new ArrayList<Integer>();
											for(int k=0;k<batchInput.get(i).get(j).size();k++){
												if(allotedSubject[k].equals("")){
													remSubjectCnt.add(k);
													allowed2 = true;
												}
											}
											
											if(allowed2){
												
												int randomValue1 = random.nextInt(remSubjectCnt.size());
												int k = remSubjectCnt.get(randomValue1);
												
												boolean done1 = false;
												boolean allowed1 = false;
												int arrayCount = 0;
												for(int l=0;l<practicalSubjectChoose.get(i).get(j).get(k).size();l++){
													if(remainingPractical.get(i).get(j).get(k).get(l)!=0){
														arrayCount++;
													}
												}
												int indexArray[] = new int[arrayCount];
												int tempIndex = 0;
												for(int l=0;l<practicalSubjectChoose.get(i).get(j).get(k).size();l++){
													if(remainingPractical.get(i).get(j).get(k).get(l)!=0){
														allowed1 = true;
														indexArray[tempIndex] = l;
														tempIndex++;
													}
												}
												if(allowed1){
													while(!done1){
														
														int tempIndex1 = random.nextInt(arrayCount);
														int l = indexArray[tempIndex1];
														if(remainingPractical.get(i).get(j).get(k).get(l)!=0){
															
															ArrayList<String> allotedTeacher = new ArrayList<String>();
															for(int p=0;p<=i;p++){
																
																int totalDivision = divisionInput.get(p).size();
																if(p == i){
																	totalDivision = j;
																}
																
																for(int q=0;q<totalDivision;q++){
																	
																	Component[] component1 = TTPanel.get(p).get(q).getComponents();
																	for(int r=0;r<component1.length;r++){
																		
																		if(component1[r].getX()==TTDay.get(p).get(q).get(dayNumber+1).getX() && component1[r].getY()==TTTime.get(p).get(q).get(randomValue*2).getY() && component1[r].getHeight()==TTTime.get(p).get(q).get(randomValue*2).getHeight()*2){
																			
																			String str = ((JTextPane)component1[r]).getText();
																			String allotedPractical[] = new String[batchInput.get(p).get(q).size()];
																			int cnt = 0,m = 0;
																			try{
																				while(str.charAt(m) != '\0'){
																					if(str.charAt(m) == '-'){
																						m = m+2;
																						StringBuilder temp = new StringBuilder();
																						try{
																							while(str.charAt(m) != '\n' && str.charAt(m) != '\0'){
																								temp.append(str.charAt(m));
																								m++;
																							}
																						}catch(Exception e){}
																						allotedPractical[cnt] = temp.toString();
																						cnt++;
																					}
																					m++;
																				}
																			}catch(Exception e){}
																			
																			for(int x=0;x<cnt;x++){
																				for(int y=0;y<practicalSubjectChoose.get(p).get(q).get(x).size();y++){
																					if(practicalSubjectChoose.get(p).get(q).get(x).get(y).getSelectedItem().equals(allotedPractical[x])){
																						for(int z=0;z<practicalSubjectTeacherChoose.get(p).get(q).get(x).get(y).size();z++){
																							allotedTeacher.add(String.valueOf(practicalSubjectTeacherChoose.get(p).get(q).get(x).get(y).get(z).getSelectedItem()));
																						}
																						break;
																					}
																				}
																			}
																		}else if(component1[r].getX()==TTDay.get(p).get(q).get(dayNumber+1).getX() && component1[r].getY()==TTTime.get(p).get(q).get(randomValue*2).getY() && component1[r].getHeight()==TTTime.get(p).get(q).get(randomValue*2).getHeight()){
																			
																			for(int y=0;y<subjectChoose.get(p).get(q).size();y++){
																				if(subjectChoose.get(p).get(q).get(y).getSelectedItem().equals(((JTextField)component1[r]).getText())){
																					for(int z=0;z<subjectTeacherChoose.get(p).get(q).get(y).size();z++){
																						allotedTeacher.add(String.valueOf(subjectTeacherChoose.get(p).get(q).get(y).get(z).getSelectedItem()));
																					}
																					break;
																				}
																			}
																			
																			Component[] component2 = TTPanel.get(p).get(q).getComponents();
																			for(int s=0;s<component2.length;s++){
																				if(component2[s].getX()==TTDay.get(p).get(q).get(dayNumber+1).getX() && component2[s].getY()==TTTime.get(p).get(q).get((randomValue*2)+1).getY() && component2[s].getHeight()==TTTime.get(p).get(q).get((randomValue*2)+1).getHeight()){
																					
																					for(int y=0;y<subjectChoose.get(p).get(q).size();y++){
																						if(subjectChoose.get(p).get(q).get(y).getSelectedItem().equals(((JTextField)component2[s]).getText())){
																							for(int z=0;z<subjectTeacherChoose.get(p).get(q).get(y).size();z++){
																								allotedTeacher.add(String.valueOf(subjectTeacherChoose.get(p).get(q).get(y).get(z).getSelectedItem()));
																							}
																							break;
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
															for(int x=0;x<batchInput.get(i).get(j).size();x++){
																if(x!=k){
																	for(int y=0;y<practicalSubjectChoose.get(i).get(j).get(x).size();y++){
																		if(practicalSubjectChoose.get(i).get(j).get(x).get(y).getSelectedItem().equals(allotedSubject[x])){
																			for(int z=0;z<practicalSubjectTeacherChoose.get(i).get(j).get(x).get(y).size();z++){
																				allotedTeacher.add(String.valueOf(practicalSubjectTeacherChoose.get(i).get(j).get(x).get(y).get(z).getSelectedItem()));
																			}
																			break;
																		}
																	}
																}
															}
															boolean allowed = true;
															for(int x=0;x<allotedTeacher.size();x++){
																for(int m=0;m<practicalSubjectTeacherChoose.get(i).get(j).get(k).get(l).size();m++){
																	if(allotedTeacher.get(x).equals(practicalSubjectTeacherChoose.get(i).get(j).get(k).get(l).get(m).getSelectedItem())){
																		allowed = false;
																		break;
																	}
																}
															}
															
															if(allowed){
																allotedSubject[k] = String.valueOf(practicalSubjectChoose.get(i).get(j).get(k).get(l).getSelectedItem());
																int num = remainingPractical.get(i).get(j).get(k).get(l);
																num--;
																remainingPractical.get(i).get(j).get(k).set(l,num);
																done1 = true;
																break;
															}else{
																boolean canBreak = true;
																for(int x=0;x<practicalSubjectChoose.get(i).get(j).get(k).size();x++){
																	if(remainingPractical.get(i).get(j).get(k).get(x)!=0){
																		boolean temp = true;
																		for(int y=0;y<practicalSubjectTeacherChoose.get(i).get(j).get(k).get(x).size();y++){
																			for(int z=0;z<allotedTeacher.size();z++){
																				if(allotedTeacher.get(z).equals(practicalSubjectTeacherChoose.get(i).get(j).get(k).get(x).get(y).getSelectedItem())){
																					temp = false;
																					break;
																				}
																			}
																			if(temp == false){ break; }
																		}
																		if(temp){
																			canBreak = false;
																			break;
																		}
																	}
																}
																if(canBreak){ break; }
															}
															
														}
													}
												}
												if(!done1){
													allotedSubject[k] = "***";
												}
											}else{
												done2 = true;
											}
										}
										
										String str = "";
										if(batchInput.get(i).get(j).size()==1||batchInput.get(i).get(j).size()==2){ str = str + "\n"; }
										for(int k=0;k<batchInput.get(i).get(j).size();k++){
											if(k!=0){ str = str + "\n"; }
											str = str + batchInput.get(i).get(j).get(k).getText() + " - " + allotedSubject[k];
										}
										
										JTextPane tempJTextPane = new JTextPane();
										tempJTextPane.setText(str);
										tempJTextPane.setBounds(TTDay.get(i).get(j).get(dayNumber+1).getX(),TTTime.get(i).get(j).get(randomValue*2).getY(),190,TTTime.get(i).get(j).get(0).getHeight()*2);
										tempJTextPane.setForeground(new Color(0,128,255));
										tempJTextPane.setBackground(new Color(204,255,255));
										tempJTextPane.setFont(new Font("TimesRoman",Font.BOLD,20));
										tempJTextPane.setEditable(false);
										tempJTextPane.setBorder(BorderFactory.createMatteBorder(3,3,3,3,new Color(255,153,153)));
										StyledDocument doc = tempJTextPane.getStyledDocument();
										SimpleAttributeSet center = new SimpleAttributeSet();
										StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
										doc.setParagraphAttributes(0, doc.getLength(), center, false);
										TTPanel.get(i).get(j).add(tempJTextPane);
										
										done = true;
										for(int k=0;k<batchInput.get(i).get(j).size();k++){
											for(int l=0;l<practicalSubjectChoose.get(i).get(j).get(k).size();l++){
												if(remainingPractical.get(i).get(j).get(k).get(l)!=0){
													done = false;
													break;
												}
											}
											if(done == false){ break; }
										}
										
									}
									
									int dayNumberArray1[] = new int[6];
									for(int x=0;x<6;x++){
										dayNumberArray1[x] = 0;
									}
									Component[] component1 = TTPanel.get(i).get(j).getComponents();
									for(int x=0;x<6;x++){
										for(int y=0;y<component1.length;y++){
											if(component1[y].getX()==TTDay.get(i).get(j).get(x+1).getX() && component1[y].getY()>=TTTime.get(i).get(j).get(0).getY()){
												if(component1[y].getHeight()==TTTime.get(i).get(j).get(0).getHeight()){
													dayNumberArray1[x] = dayNumberArray1[x]+1;
												}else if(component1[y].getHeight()==(TTTime.get(i).get(j).get(0).getHeight()*2)){
													dayNumberArray1[x] = dayNumberArray1[x]+2;
												}
											}
										}
									}
									for(int x=0;x<6;x++){
										if(dayNumberArray1[x]==6 || (x==5&&dayNumberArray1[x]==4)){
											dayNumberArray1[x]=1;
										}else{
											dayNumberArray1[x]=0;
										}
									}
									ArrayList<Integer> dayNumberCntArray1 = new ArrayList<Integer>();
									for(int x=0;x<6;x++){
										if(dayNumberArray1[x] == 0){ dayNumberCntArray1.add(x); }
									}
									if(dayNumberCntArray1.size() == 0){
										break;
									}
									
								}
								
								int maxPractBlock = 0;
								for(int k=0;k<batchInput.get(i).get(j).size();k++){
									if(maxPractBlock < practicalSubjectChoose.get(i).get(j).get(k).size()){
										maxPractBlock = practicalSubjectChoose.get(i).get(j).get(k).size();
									}
								}
								
								int practBlockCnt = 0;
								for(int x=0;x<6;x++){
									for(int y=0;y<3;y++){
										if(x!=5 || (x==5&&y!=2)){
											Component[] component3 = TTPanel.get(i).get(j).getComponents();
											for(int z=0;z<component3.length;z++){
												if(component3[z].getX()==TTDay.get(i).get(j).get(x+1).getX() && component3[z].getY()==TTTime.get(i).get(j).get(y*2).getY() && component3[z].getHeight()==TTTime.get(i).get(j).get(y*2).getHeight()*2){
													practBlockCnt++;
												}
											}
										}
									}
								}
								
								if(!(maxPractBlock >= practBlockCnt)){
									
									if(counter2 == 1000){
									
										int blockCnt[] = new int[1000];
										for(int x=0;x<1000;x++){
											blockCnt[x] = 0;
										}
										
										for(int x=0;x<1000;x++){
											
											Component[] component7 = tempJPanel[x].getComponents();
											for(int z=0;z<component7.length;z++){
												if(component7[z].getX()>=TTDay.get(i).get(j).get(1).getX() && component7[z].getY()>=TTTime.get(i).get(j).get(0).getY()){
													blockCnt[x]++;
												}
											}
											
										}
										
										int minCnt = 0;
										for(int x=1;x<1000;x++){
											if(blockCnt[x] < blockCnt[x-1]){
												minCnt = x;
											}
										}
										
										Component[] component8 = TTPanel.get(i).get(j).getComponents();
										for(int z=0;z<component8.length;z++){
											if(component8[z].getX()>=TTDay.get(i).get(j).get(1).getX() && component8[z].getY()>=TTTime.get(i).get(j).get(0).getY()){
												TTPanel.get(i).get(j).remove(component8[z]);
											}
										}
										
										Component[] component9 = tempJPanel[minCnt].getComponents();
										for(int z=0;z<component9.length;z++){
											if(component9[z].getX()>=TTDay.get(i).get(j).get(1).getX() && component9[z].getY()>=TTTime.get(i).get(j).get(0).getY()){
												TTPanel.get(i).get(j).add(component9[z]);
											}
										}
										
										perfectPractical = true;
										
									}else{
										
										Component[] component5 = TTPanel.get(i).get(j).getComponents();
										for(int z=0;z<component5.length;z++){
											if(component5[z].getX()>=TTDay.get(i).get(j).get(1).getX() && component5[z].getY()>=TTTime.get(i).get(j).get(0).getY()){
												
												String str = ((JTextPane)component5[z]).getText();
												String allotedPractical[] = new String[batchInput.get(i).get(j).size()];
												int cnt = 0,m = 0;
												try{
													while(str.charAt(m) != '\0'){
														if(str.charAt(m) == '-'){
															m = m+2;
															StringBuilder temp = new StringBuilder();
															try{
																while(str.charAt(m) != '\n' && str.charAt(m) != '\0'){
																	temp.append(str.charAt(m));
																	m++;
																}
															}catch(Exception e){}
															allotedPractical[cnt] = temp.toString();
															cnt++;
														}
														m++;
													}
												}catch(Exception e){}
												
												int starCnt = 0;
												for(int x=0;x<cnt;x++){
													if(allotedPractical[x].equals("***")){
														starCnt++;
													}
												}
												
												if(starCnt == cnt){
													TTPanel.get(i).get(j).remove(component5[z]);
												}
												
											}
										}
										
										Component[] component6 = TTPanel.get(i).get(j).getComponents();
										for(int z=0;z<component6.length;z++){
											if(component6[z].getX()>=TTDay.get(i).get(j).get(1).getX() && component6[z].getY()>=TTTime.get(i).get(j).get(0).getY()){
												tempJPanel[counter2].add(component6[z]);
											}
										}
										
										Component[] component3 = TTPanel.get(i).get(j).getComponents();
										for(int z=0;z<component3.length;z++){
											if(component3[z].getX()>=TTDay.get(i).get(j).get(1).getX() && component3[z].getY()>=TTTime.get(i).get(j).get(0).getY()){
												TTPanel.get(i).get(j).remove(component3[z]);
											}
										}
										for(int k=0;k<batchInput.get(i).get(j).size();k++){
											for(int l=0;l<practicalSubjectChoose.get(i).get(j).get(k).size();l++){
												for(int x=0;x<subjectNameInput.size();x++){
													if(subjectNameInput.get(x).getText().equals(practicalSubjectChoose.get(i).get(j).get(k).get(l).getSelectedItem())){
														remainingPractical.get(i).get(j).get(k).set(l,Integer.parseInt(practicalPerWeek.get(x).getText()));
													}
												}
											}
										}
										
										counter2++;
										perfectPractical = false;
										
									}
									
								}
								
							}
							
						}
						/////////////////////////////////////////////////////////////////////////////////
						
						/////////////////////////////// For Lecture Schedule ////////////////////////////
						if(!(subjectChoose.get(i).get(j).size()==1 && subjectChoose.get(i).get(j).get(0).getSelectedItem().equals("Select Subject For Lecture") && subjectTeacherChoose.get(i).get(j).get(0).size()==1 && subjectTeacherChoose.get(i).get(j).get(0).get(0).getSelectedItem().equals("Select Teacher For Lecture"))){
							
							int counter3 = 0;
							boolean perfectLecture = false;
							while(!perfectLecture){
								
								perfectLecture = true;
								int counter1 = 0;
								
								int dayNumberArray1[] = new int[6];
								int dayNumber = 0;
								for(int x=0;x<6;x++){
									dayNumberArray1[x] = 1;
								}
								
								ArrayList<Integer> subjectCntArray = new ArrayList<Integer>();
								for(int x=0;x<subjectChoose.get(i).get(j).size();x++){
									if(remainingLecture.get(i).get(j).get(x)!=0){
										subjectCntArray.add(x);
									}
								}
								int k = subjectCntArray.get(random.nextInt(subjectCntArray.size()));
								
								boolean done3 = false;
								while(!done3){
									
									ArrayList<Integer> dayNumberCntArray = new ArrayList<Integer>();
									for(int x=0;x<6;x++){
										if(dayNumberArray1[x] == 0){ dayNumberCntArray.add(x); }
									}
									if(dayNumberCntArray.size() == 0 || remainingLecture.get(i).get(j).get(k)==0){
										for(int x=0;x<6;x++){
											dayNumberArray1[x] = 0;
										}
										Component[] component1 = TTPanel.get(i).get(j).getComponents();
										for(int x=0;x<6;x++){
											for(int y=0;y<component1.length;y++){
												if(component1[y].getX()==TTDay.get(i).get(j).get(x+1).getX() && component1[y].getY()>=TTTime.get(i).get(j).get(0).getY()){
													if(component1[y].getHeight()==TTTime.get(i).get(j).get(0).getHeight()){
														dayNumberArray1[x] = dayNumberArray1[x]+1;
													}else if(component1[y].getHeight()==(TTTime.get(i).get(j).get(0).getHeight()*2)){
														dayNumberArray1[x] = dayNumberArray1[x]+2;
													}
												}
											}
										}
										for(int x=0;x<6;x++){
											if(dayNumberArray1[x]==6 || (x==5&&dayNumberArray1[x]==4)){
												dayNumberArray1[x]=1;
											}else{
												dayNumberArray1[x]=0;
											}
										}
										for(int x=0;x<6;x++){
											if(dayNumberArray1[x] == 0){ dayNumberCntArray.add(x); }
										}
									}
									if(dayNumberCntArray.size() != 0){
										dayNumber = dayNumberCntArray.get(random.nextInt(dayNumberCntArray.size()));
									}else{
										break;
									}
									
									int randomValue = random.nextInt(6);
									boolean allowed3 = true;
									Component[] component = TTPanel.get(i).get(j).getComponents();
									for(int x=0;x<component.length;x++){
										if(component[x].getX()==TTDay.get(i).get(j).get(dayNumber+1).getX() && component[x].getY()==TTTime.get(i).get(j).get(randomValue).getY()){
											allowed3 = false;
										}else if(randomValue%2==1){
											if(component[x].getX()==TTDay.get(i).get(j).get(dayNumber+1).getX() && component[x].getY()==TTTime.get(i).get(j).get(randomValue-1).getY() && component[x].getHeight()==(TTTime.get(i).get(j).get(randomValue-1).getHeight()*2)){
												allowed3 = false;
											}
										}
									}
									
									if(remainingLecture.get(i).get(j).get(k)==0){
										subjectCntArray.clear();
										for(int x=0;x<subjectChoose.get(i).get(j).size();x++){
											if(remainingLecture.get(i).get(j).get(x)!=0){
												subjectCntArray.add(x);
											}
										}
										k = subjectCntArray.get(random.nextInt(subjectCntArray.size()));
									}
									
									ArrayList<String> allotedTeacher = new ArrayList<String>();
									for(int p=0;p<=i;p++){
										
										int totalDivision = divisionInput.get(p).size();
										if(p == i){
											totalDivision = j;
										}
										
										for(int q=0;q<totalDivision;q++){
											
											Component[] component1 = TTPanel.get(p).get(q).getComponents();
											for(int r=0;r<component1.length;r++){
												
												if(component1[r].getX()==TTDay.get(p).get(q).get(dayNumber+1).getX() && component1[r].getY()==TTTime.get(p).get(q).get(randomValue).getY() && component1[r].getHeight()==TTTime.get(p).get(q).get(randomValue).getHeight()){
													
													for(int y=0;y<subjectChoose.get(p).get(q).size();y++){
														if(subjectChoose.get(p).get(q).get(y).getSelectedItem().equals(((JTextField)component1[r]).getText())){
															for(int z=0;z<subjectTeacherChoose.get(p).get(q).get(y).size();z++){
																allotedTeacher.add(String.valueOf(subjectTeacherChoose.get(p).get(q).get(y).get(z).getSelectedItem()));
															}
															break;
														}
													}
													
												}else if(component1[r].getX()==TTDay.get(p).get(q).get(dayNumber+1).getX() && component1[r].getY()==TTTime.get(p).get(q).get(randomValue).getY() && component1[r].getHeight()==TTTime.get(p).get(q).get(randomValue).getHeight()*2){
													
													String str = ((JTextPane)component1[r]).getText();
													String allotedPractical[] = new String[batchInput.get(p).get(q).size()];
													int cnt = 0,m = 0;
													try{
														while(str.charAt(m) != '\0'){
															if(str.charAt(m) == '-'){
																m = m+2;
																StringBuilder temp = new StringBuilder();
																try{
																	while(str.charAt(m) != '\n' && str.charAt(m) != '\0'){
																		temp.append(str.charAt(m));
																		m++;
																	}
																}catch(Exception e){}
																allotedPractical[cnt] = temp.toString();
																cnt++;
															}
															m++;
														}
													}catch(Exception e){}
													
													for(int x=0;x<cnt;x++){
														for(int y=0;y<practicalSubjectChoose.get(p).get(q).get(x).size();y++){
															if(practicalSubjectChoose.get(p).get(q).get(x).get(y).getSelectedItem().equals(allotedPractical[x])){
																for(int z=0;z<practicalSubjectTeacherChoose.get(p).get(q).get(x).get(y).size();z++){
																	allotedTeacher.add(String.valueOf(practicalSubjectTeacherChoose.get(p).get(q).get(x).get(y).get(z).getSelectedItem()));
																}
																break;
															}
														}
													}
													
												}else if(randomValue%2==1){
													if(component1[r].getX()==TTDay.get(p).get(q).get(dayNumber+1).getX() && component1[r].getY()==TTTime.get(p).get(q).get(randomValue-1).getY() && component1[r].getHeight()==TTTime.get(p).get(q).get(randomValue-1).getHeight()*2){
														
														String str = ((JTextPane)component1[r]).getText();
														String allotedPractical[] = new String[batchInput.get(p).get(q).size()];
														int cnt = 0,m = 0;
														try{
															while(str.charAt(m) != '\0'){
																if(str.charAt(m) == '-'){
																	m = m+2;
																	StringBuilder temp = new StringBuilder();
																	try{
																		while(str.charAt(m) != '\n' && str.charAt(m) != '\0'){
																			temp.append(str.charAt(m));
																			m++;
																		}
																	}catch(Exception e){}
																	allotedPractical[cnt] = temp.toString();
																	cnt++;
																}
																m++;
															}
														}catch(Exception e){}
														
														for(int x=0;x<cnt;x++){
															for(int y=0;y<practicalSubjectChoose.get(p).get(q).get(x).size();y++){
																if(practicalSubjectChoose.get(p).get(q).get(x).get(y).getSelectedItem().equals(allotedPractical[x])){
																	for(int z=0;z<practicalSubjectTeacherChoose.get(p).get(q).get(x).get(y).size();z++){
																		allotedTeacher.add(String.valueOf(practicalSubjectTeacherChoose.get(p).get(q).get(x).get(y).get(z).getSelectedItem()));
																	}
																	break;
																}
															}
														}
														
													}
												}
											}
										}
									}
									
									for(int x=0;x<allotedTeacher.size();x++){
										for(int l=0;l<subjectTeacherChoose.get(i).get(j).get(k).size();l++){
											if(allotedTeacher.get(x).equals(subjectTeacherChoose.get(i).get(j).get(k).get(l).getSelectedItem())){
												allowed3 = false;
												break;
											}
										}
									}
									
									if(allowed3 && ((randomValue!=4&&randomValue!=5)||dayNumber!=5)){
										
										counter1 = 0;
										
										dayNumberArray1[dayNumber] = 1;
										
										JTextField tempJTextField = new JTextField();
										tempJTextField.setText(String.valueOf(subjectChoose.get(i).get(j).get(k).getSelectedItem()));
										int num = remainingLecture.get(i).get(j).get(k);
										num--;
										remainingLecture.get(i).get(j).set(k,num);
										tempJTextField.setBounds(TTDay.get(i).get(j).get(dayNumber+1).getX(),TTTime.get(i).get(j).get(randomValue).getY(),190,TTTime.get(i).get(j).get(randomValue).getHeight());
										tempJTextField.setForeground(new Color(0,128,255));
										tempJTextField.setBackground(new Color(204,255,255));
										tempJTextField.setFont(new Font("TimesRoman",Font.BOLD,20));
										tempJTextField.setBorder(BorderFactory.createMatteBorder(3,3,3,3,new Color(255,153,153)));
										tempJTextField.setHorizontalAlignment(JTextField.CENTER);
										tempJTextField.setEditable(false);
										TTPanel.get(i).get(j).add(tempJTextField);
										
										done3 = true;
										for(int x=0;x<subjectChoose.get(i).get(j).size();x++){
											if(remainingLecture.get(i).get(j).get(x)!=0){
												done3 = false;
												break;
											}
											if(done3 == false){ break; }
										}
										
									}
									
									counter1++;
									if(counter1==1000){
										
										Component[] component3 = TTPanel.get(i).get(j).getComponents();
										for(int z=0;z<component3.length;z++){
											if(component3[z].getX()>=TTDay.get(i).get(j).get(1).getX() && component3[z].getY()>=TTTime.get(i).get(j).get(0).getY() && component3[z].getHeight()==TTTime.get(i).get(j).get(0).getHeight()){
												TTPanel.get(i).get(j).remove(component3[z]);
											}
										}
										for(int x=0;x<subjectChoose.get(i).get(j).size();x++){
											for(int y=0;y<subjectNameInput.size();y++){
												if(subjectNameInput.get(y).getText().equals(subjectChoose.get(i).get(j).get(x).getSelectedItem())){
													remainingLecture.get(i).get(j).set(x,Integer.parseInt(lecturePerWeek.get(y).getText()));
												}
											}
										}
										perfectLecture = false;
										break;
										
									}
									
								}
								
								counter3++;
								if(counter3 == 1000){
									PutTTAgain = true;
									break;
								}
							
							}
							
						}
						/////////////////////////////////////////////////////////////////////////////////
						
						////////////////////////////////For Fill Empty Space/////////////////////////////
						if(!PutTTAgain){
							for(int x=0;x<6;x++){
								for(int y=0;y<6;y++){
									if(x!=5 || (x==5&&y!=4&&y!=5)){
										boolean isEmpty = true;
										Component[] component1 = TTPanel.get(i).get(j).getComponents();
										for(int z=0;z<component1.length;z++){
											if(component1[z].getX()==TTDay.get(i).get(j).get(x+1).getX() && component1[z].getY()==TTTime.get(i).get(j).get(y).getY()){
												isEmpty = false;
												break;
											}
										}
										if(isEmpty && y%2==1){
											Component[] component2 = TTPanel.get(i).get(j).getComponents();
											for(int z=0;z<component2.length;z++){
												if(component2[z].getX()==TTDay.get(i).get(j).get(x+1).getX() && component2[z].getY()==TTTime.get(i).get(j).get(y-1).getY() && component2[z].getHeight()==(TTTime.get(i).get(j).get(y-1).getHeight()*2)){
													isEmpty = false;
													break;
												}
											}
										}
										if(isEmpty){
											JTextField tempJTextField = new JTextField("-");
											tempJTextField.setBounds(TTDay.get(i).get(j).get(x+1).getX(),TTTime.get(i).get(j).get(y).getY(),190,TTTime.get(i).get(j).get(y).getHeight());
											tempJTextField.setForeground(new Color(0,128,255));
											tempJTextField.setBackground(new Color(204,255,255));
											tempJTextField.setFont(new Font("TimesRoman",Font.BOLD,20));
											tempJTextField.setBorder(BorderFactory.createMatteBorder(3,3,3,3,new Color(255,153,153)));
											tempJTextField.setHorizontalAlignment(JTextField.CENTER);
											tempJTextField.setEditable(false);
											TTPanel.get(i).get(j).add(tempJTextField);
										}
									}
								}
							}
						}
						/////////////////////////////////////////////////////////////////////////////////
					
						if(PutTTAgain){ break; }
					}
					
					if(PutTTAgain){ break; }
				}
				
			}
		
		}catch(Exception e){}
		
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	public void ConfirmPage(){
		
		confirmf = new JFrame("Confirmation");
		confirmf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		confirmf.setSize(800,400);
		confirmf.setLocationRelativeTo(null);
		confirmf.setLayout(null);
		confirmf.setUndecorated(true);
		confirmf.setIconImage(i1.getImage());
		confirmf.setVisible(false);
		
		p6 = new JPanel();
		p6.setBounds(0,0,800,400);
		p6.setOpaque(false);
		p6.setLayout(null);
		confirmf.add(p6);
		
		l7 = new JLabel("Are You Sure ?");
		l7.setFont(new Font("TimesRoman",Font.BOLD,60));
		l7.setBounds(200,100,400,100);
		l7.setForeground(new Color(255,0,0));
		p6.add(l7);
		
		i18 = new ImageIcon("IconsTimeTable\\yes_key.png");
		i18 = new ImageIcon(i18.getImage().getScaledInstance(150,70,java.awt.Image.SCALE_SMOOTH));
		b9 = new JButton(i18);
		b9.setBounds(210,230,i18.getIconWidth(),i18.getIconHeight());
		b9.setOpaque(false);
		b9.setContentAreaFilled(false);
		b9.setBorderPainted(false);
		b9.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
		b9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(confirmfBy.equals("delete")){
					
				}else if(confirmfBy.equals("edit")){
					
				}else if(confirmfBy.equals("home")){
					title.setText("Enter Title Of TimeTable");
					title.setForeground(new Color(102,178,225));
					title.setFont(new Font("TimesRoman",Font.BOLD+Font.ITALIC,65));
					
					for(int i=0;i<teacherNameInput.size();i++){
						ep[0].remove(teacherNameInput.get(i));
						ep[0].remove(teacherNameCross.get(i));
					}
					teacherNameInput.clear();
					teacherNameCross.clear();
					addTeacherCount.setText("1");
					
					for(int i=0;i<subjectNameInput.size();i++){
						ep[0].remove(subjectNameInput.get(i));
						ep[0].remove(subjectNameCross.get(i));
						ep[0].remove(haveLecture.get(i));
						ep[0].remove(havePractical.get(i));
						ep[0].remove(timePerLecture.get(i));
						ep[0].remove(lecturePerWeek.get(i));
						ep[0].remove(timePerPractical.get(i));
						ep[0].remove(practicalPerWeek.get(i));
					}
					subjectNameInput.clear();
					subjectNameCross.clear();
					haveLecture.clear();
					havePractical.clear();
					timePerLecture.clear();
					lecturePerWeek.clear();
					timePerPractical.clear();
					practicalPerWeek.clear();
					addSubjectCount.setText("1");
					
					RearrangeFirstEditPage();
					
					for(int i=0;i<classInputPanel.size();i++){
						try{
							ep[1].remove(classInputPanel.get(i));
						}catch(Exception e){}
						try{
							ep[2].remove(classInputPanel.get(i));
						}catch(Exception e){}
					}
						
					try{
						practicalSubjectTeacherChooseCross.clear();
					}catch(Exception e){}
					practicalSubjectTeacherChoose.clear();
					practicalSubjectTeacherChoosePanel.clear();
					practicalSubjectTeacherChooseAdd.clear();
					try{
						practicalSubjectChooseCross.clear();
					}catch(Exception e){}
					practicalSubjectChoose.clear();
					practicalSubjectChoosePanel.clear();
					practicalSubjectChooseAdd.clear();
					try{
						batchInputCross.clear();
					}catch(Exception e){}
					batchInput.clear();
					batchInputPanel.clear();
					batchInputAdd.clear();
					
					try{
						subjectTeacherChooseCross.clear();
					}catch(Exception e){}
					subjectTeacherChoose.clear();
					subjectTeacherChoosePanel.clear();
					subjectTeacherChooseAdd.clear();
					try{
						subjectChooseCross.clear();
					}catch(Exception e){}
					subjectChoose.clear();
					subjectChoosePanel.clear();
					subjectChooseAdd.clear();
					try{
						divisionInputCross.clear();
					}catch(Exception e){}
					divisionInput.clear();
					divisionInputPanel.clear();
					divisionInputAdd.clear();
					classInputCross.clear();
					classInput.clear();
					classInputPanel.clear();
					
					ClassInputAddFunction();
					
					RearrangeSecondEditPage();
					RearrangeThirdEditPage();
					
					for(int x=0;x<3;x++){
						ep[x].setBounds(0,0,ep[x].getWidth(),ep[x].getHeight());
					}
					SetEditPanelValue(0);
					
					p1.setVisible(true);
					p4.setVisible(false);
					TTMainPanel.setVisible(false);
					f.setEnabled(true);
					confirmf.dispose();
				}
			}
		});
		p6.add(b9);
		
		i19 = new ImageIcon("IconsTimeTable\\no_key.png");
		i19 = new ImageIcon(i19.getImage().getScaledInstance(150,70,java.awt.Image.SCALE_SMOOTH));
		b10 = new JButton(i19);
		b10.setBounds(440,230,i19.getIconWidth(),i19.getIconHeight());
		b10.setOpaque(false);
		b10.setContentAreaFilled(false);
		b10.setBorderPainted(false);
		b10.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
		b10.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				f.setEnabled(true);
				confirmf.dispose();
			}
		});
		p6.add(b10);
		
		i17 = new ImageIcon("IconsTimeTable\\confirm_panel.png");
		i17 = new ImageIcon(i17.getImage().getScaledInstance(800,400,java.awt.Image.SCALE_SMOOTH));
		l6 = new JLabel(i17);
		l6.setBounds(0,0,800,400);
		l6.setOpaque(false);
		p6.add(l6);
		
		confirmf.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
	}
	
	public void InformPage(){
		
		informf = new JFrame("Information");
		informf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		informf.setSize(800,400);
		informf.setLocationRelativeTo(null);
		informf.setLayout(null);
		informf.setUndecorated(true);
		informf.setIconImage(i1.getImage());
		informf.setVisible(false);
		
		p7 = new JPanel();
		p7.setBounds(0,0,800,400);
		p7.setOpaque(false);
		p7.setLayout(null);
		informf.add(p7);
		
		l8 = new JLabel("Successfully Saved !");
		l8.setFont(new Font("TimesRoman",Font.BOLD,60));
		l8.setBounds(143,100,514,100);
		l8.setForeground(new Color(0,255,0));
		p7.add(l8);
		
		i20 = new ImageIcon("IconsTimeTable\\ok_key.png");
		i20 = new ImageIcon(i20.getImage().getScaledInstance(250,70,java.awt.Image.SCALE_SMOOTH));
		b11 = new JButton(i20);
		b11.setBounds(275,230,i20.getIconWidth(),i20.getIconHeight());
		b11.setOpaque(false);
		b11.setContentAreaFilled(false);
		b11.setBorderPainted(false);
		b11.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.black));
		b11.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				f.setEnabled(true);
				informf.dispose();
			}
		});
		p7.add(b11);
		
		l9 = new JLabel(i17);
		l9.setBounds(0,0,800,400);
		l9.setOpaque(false);
		p7.add(l9);
		
		informf.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void main(String args[]){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new TimeTable();
			}
		});
	}
	
}