import java.awt.*;//graphical elements
import java.awt.event.*;
// added annotations
public class Character{
//	private Frame Cframe; frame is rudundant purpose was as statsFrame
	private Frame tempC; //frame for new character
	private Label instructL;
	private TextField nameF;
	private Panel Cpanel;
	private Button submit;// button here so accessible outside Character constructor, there may not be a erason for this...
	private Frame charClass;
	private Frame statsFrame;
	private Label namel;
	private Label classl;
	private Label levell;
	private Label xpl;
	private Label strl;
	private Label conl;
	private Label dexl;
	private Label Intl;
	private Label chal;
	private Label wisl;
	int gil = 0;//money
	int hp;//life
	int lvl= 1;
	int xp = 0;
	int str;//strength value
	int cha;//charisma value
	int con;//constitution value
	int dex;//dexterity value
	int wis;//wisdom value
	int Int;//intelegence value
	public Dice d6 = new Dice(5,6);// d20(changed) rolls to 30? should be d6's; rolls 5 d6; need to add dice class (oops)
	public Dice mod =  new Dice(3,6);// stat modifier for improved stats
	public Dice Dlvl = new Dice(1,3);// lvl up dice
	
	String name;
	String Class;
	private boolean hasName;
	private Frame conStatsF;
	private Label conStatsStr;
	private Label conStatsCon;
	private Label conStatsDex;
	private Label conStatsInt;
	private Label conStatsCha;
	private Label conStatsWis;
	public Character (){// constructor
		tempC = new Frame ("new character");// frame titled "new character"
		tempC.setSize(300,200);
		tempC.setLocationRelativeTo(null);//centralized frame
		tempC.setLayout(new GridLayout(3,1));
		tempC.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        //ends program
		});
		GridBagLayout layout = new GridBagLayout();//customizable layout based on grid quadinates 
		nameF = new TextField(30);//allows a player to choose a name.
		Cpanel = new Panel();
		Cpanel.setLayout (layout);
		instructL = new Label();
		instructL.setText("enter character name");
		submit = new Button(">");
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
			gbc.gridy = 0;
			Cpanel.add(nameF,gbc);
		
		gbc.gridx = 1;
			gbc.gridy = 0 ;
			Cpanel.add(submit,gbc);
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// class choice after name is entered
					Button rog = new Button("rogue");
					rog.setActionCommand("rog");
					rog.addActionListener(new ButtonClickListenerC());
					Button war = new Button("warrior");
					war.setActionCommand("war");
					war.addActionListener(new ButtonClickListenerC());
					Button mag = new Button("mage");
					mag.setActionCommand("mag");
					mag.addActionListener(new ButtonClickListenerC());
					name =nameF.getText();
					if (name.equals("")) name = "Anon";
					hasName = true;
					nameF.setVisible(false);
					submit.setVisible(false);
					tempC.dispose();
					charClass = new Frame("class");
					charClass.setSize(200,100);
					charClass.setLocationRelativeTo(null);
					charClass.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent windowEvent){
							System.exit(0);
						}        
					});
					GridBagLayout layout = new GridBagLayout();
					charClass.setLayout(layout);
					Label info = new Label("pick a class");
					GridBagConstraints gbc = new GridBagConstraints();
						gbc.fill = GridBagConstraints.HORIZONTAL;
						gbc.gridx = 0;
						gbc.gridy = 0;
						charClass.add(info,gbc);
		
						gbc.fill = GridBagConstraints.HORIZONTAL;
						gbc.gridx = 0;
						gbc.gridy = 1 ;
						charClass.add(rog,gbc);
						
						gbc.gridx = 2;
						gbc.gridy = 1 ;
						charClass.add(war,gbc);
						
						gbc.gridx = 3;
						gbc.gridy = 1 ;
						charClass.add(mag,gbc);
					charClass.setVisible(true);
			}
		});	
		tempC.add(instructL);
		tempC.add(Cpanel);
		tempC.setVisible(true);
	}
	public void displayStats(){//displayes all values displayed here, with values the weapons, AC, armor etc, will be displayed in Inventory.java, and will be created from ItemCodex.java (neither here yet)
	statsFrame = new Frame(name+", "+Class+", level: "+lvl);
	statsFrame.setSize(300,300);
	statsFrame.setLocation(1000,200);// sets location as fixed to almost the right edge, problem when scaling down needs adressing
	statsFrame.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent windowEvent){
			statsFrame.dispose();
         }        
		});
	namel = new Label(name);
	classl = new Label(Class);
	levell = new Label("level: "+lvl);
	xpl = new Label("exp: " + xp);
	strl = new Label("strength: " + str);
	conl = new Label("constitution: " + con );
	dexl = new Label("dexterity: " + dex);
	Intl = new Label("intelligence: " + Int);
	chal = new Label("charisma: "+ cha);
	wisl = new Label("wisdom: "+ wis);
	GridBagLayout layout = new GridBagLayout();
	statsFrame.setLayout(layout);
	GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
			gbc.gridy = 0;
			statsFrame.add(namel,gbc);
			gbc.gridx = 1;
			gbc.gridy = 0;
			statsFrame.add(classl,gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
			gbc.gridy = 1;
			statsFrame.add(levell,gbc);
			gbc.gridx = 1;
			gbc.gridy = 1;
			statsFrame.add(xpl,gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
			gbc.gridy = 2;
			statsFrame.add(strl,gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
			gbc.gridy = 3;
			statsFrame.add(conl,gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
			gbc.gridy = 4;
			statsFrame.add(dexl,gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
			gbc.gridy = 5;
			statsFrame.add(Intl,gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
			gbc.gridy = 6;
			statsFrame.add(chal,gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
			gbc.gridy = 7;
			statsFrame.add(wisl,gbc);
			statsFrame.setVisible(true);
			updateStats();
	}
	public void updateStats(){// changes the values of the stats labels, should be used whenever a stat change might happen, every turn may be advisable
		statsFrame.setTitle("Stats :"+ name+", "+Class+", level: "+lvl);
		levell.setText("level: "+lvl);
		xpl.setText("exp: " + xp);
		strl.setText("strength: " + str);
		conl.setText("constitution: " + con );
		dexl.setText("dexterity: " + dex);
		Intl.setText("intelligence: " + Int);
		chal.setText("charisma: "+ cha);
		wisl.setText("wisdom: "+ wis);
	}
	public void confirmStats(){// displays statsGen 
		conStatsF = new Frame("confirm stats");
		conStatsF.setLocation(500,200);
		conStatsStr = new Label("strength :"+ str);
		conStatsCon = new Label("constitution:"+ con);
		conStatsDex = new Label("Dexterity:"+ dex);
		conStatsInt = new Label("intelligence :"+ Int);
		conStatsCha = new Label("Charisma :"+ cha);
		conStatsWis = new Label("wisdom :"+ wis);
		Label goodStats = new Label("are these stats ok?");
		
		Button yes = new Button("yes");
			yes.setActionCommand("yes");
			yes.addActionListener(new conStatsListner());
		Button no = new Button("no");
			no.setActionCommand("no");
			no.addActionListener(new conStatsListner());
		GridBagLayout layout = new GridBagLayout();
		
		conStatsF.setLayout(layout);
		conStatsF.setSize(250,300);
		conStatsF.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
		});
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
			gbc.gridy = 0;
			conStatsF.add(conStatsStr,gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
			gbc.gridy = 1;
			conStatsF.add(conStatsCon,gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
			gbc.gridy = 2;
			conStatsF.add(conStatsDex,gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
			gbc.gridy = 3;
			conStatsF.add(conStatsInt,gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
			gbc.gridy = 4;
			conStatsF.add(conStatsCha,gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
			gbc.gridy = 5;
			conStatsF.add(conStatsWis,gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
			gbc.gridy = 6;
			conStatsF.add(goodStats,gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
			gbc.gridy = 7;
			conStatsF.add(yes,gbc);
			gbc.gridx = 1;
			gbc.gridy = 7;
			conStatsF.add(no,gbc);
		conStatsF.setVisible(true);
	}
	private class conStatsListner implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
				if (command.equals("yes")){
					conStatsF.dispose();
					displayStats();
				}
				if (command.equals("no")){
					genStats();
					conStatsF.dispose();
					confirmStats();
				}
			}
		}
	public void genStats(){//generates stats, based on class
		if(Class.equals("Rogue")){			
			str = d6.rollMinusLowest();
			con = d6.rollMinusLowest();
			dex = d6.rollMinusLowest()+mod.rollMinusLowest();
			Int = d6.rollMinusLowest();
			cha = d6.rollMinusLowest()+mod.rollMinusLowest();
			wis = d6.rollMinusLowest();
		}
		else if(Class.equals("Warrior")){
			str = d6.rollMinusLowest()+mod.rollMinusLowest();
			con = d6.rollMinusLowest()+mod.rollMinusLowest();
			dex = d6.rollMinusLowest();
			Int = d6.rollMinusLowest();
			cha = d6.rollMinusLowest();
			wis = d6.rollMinusLowest();
		}
		else if(Class.equals("Mage")){
			str = d6.rollMinusLowest();
			con = d6.rollMinusLowest();
			dex = d6.rollMinusLowest();
			Int = d6.rollMinusLowest()+mod.rollMinusLowest();
			cha = d6.rollMinusLowest();
			wis = d6.rollMinusLowest()+mod.rollMinusLowest();
		}
	}
	
private class ButtonClickListenerC implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
				if (command.equals("rog"))Class=("Rogue");
				if (command.equals("war"))Class=("Warrior");
				if (command.equals("mag"))Class=("Mage");
				charClass.dispose();
				genStats();
				confirmStats();
			}
		}
	private Frame LVLUP;
	public void levelUp(){
		int oldLvl=lvl;
		lvl++;
		if(Class.equals("Rogue")){
			str+=Dlvl.roll()-1;
			con+=Dlvl.roll()-1;
			dex+=Dlvl.roll();
			Int+=Dlvl.roll()-1;
			cha+=Dlvl.roll();
			wis+=Dlvl.roll()-1;
		}
		if(Class.equals("Warrior")){
			str+=Dlvl.roll();
			con+=Dlvl.roll();
			dex+=Dlvl.roll()-1;
			Int+=Dlvl.roll()-1;
			cha+=Dlvl.roll()-1;
			wis+=Dlvl.roll()-1;
		}
		if(Class.equals("Mage")){
			str+=Dlvl.roll()-1;
			con+=Dlvl.roll()-1;
			dex+=Dlvl.roll()-1;
			Int+=Dlvl.roll();
			cha+=Dlvl.roll()-1;
			wis+=Dlvl.roll();
		}
		if(str>100)str=100;//max in any stat  100
		if(con>100)con=100;
		if(dex>100)dex=100;
		if(Int>100)Int=100;
		if(cha>100)cha=100;
		if(wis>100)wis=100;
		if(str==100&&con==100&&dex==100&&Int==100&&cha==100&&wis==100)lvl--;//max level is the level when all stats max, usually between 80 and 120
			if(lvl > oldLvl){
				xp=0;
				LVLUP = new Frame ("level up!");
				LVLUP.setSize(185,100);
				LVLUP.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent windowEvent){
						LVLUP.dispose();
						updateStats();
					}        
				});
				LVLUP.setLocation(500,300);
				Label LvlUp = new Label (name + " has reached Level "+ lvl);
				LVLUP.setLayout(new GridLayout(2,1));
				LVLUP.add(LvlUp);
				Button close = new Button ("ok");
				close.addActionListener(new lvlListener());
				LVLUP.add(close);
				LVLUP.setVisible(true);
			}
		}
		private class lvlListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			LVLUP.dispose();
			updateStats();
			}
		}
public static void main(String[] args){//will not be removed present for test executions 
	Character chara = new Character();
	}
}
