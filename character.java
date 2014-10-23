import java.awt.*;
import java.awt.event.*;

public class Character{
	private Frame Cframe;
	private Frame tempC;
	private Label instructL;
	private TextField nameF;
	private Panel Cpanel;
	private Button submit;
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
	int gil = 0;
	int hp;
	int lvl= 1;
	int xp = 0;
	int str;
	int cha;
	int con;
	int dex;
	int wis;
	int Int;
	public Dice d20 = new Dice(5,6);
	public Dice mod =  new Dice(3,6);
	public Dice Dlvl = new Dice(1,3);
	
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
	public Character (){
		tempC = new Frame ("new character");
		tempC.setSize(300,200);
		tempC.setLocationRelativeTo(null);
		tempC.setLayout(new GridLayout(3,1));
		tempC.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
		});
		GridBagLayout layout = new GridBagLayout();
		nameF = new TextField(30);
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
			public void actionPerformed(ActionEvent e) {
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
	public void displayStats(){
	statsFrame = new Frame(name+", "+Class+", level: "+lvl);
	statsFrame.setSize(300,300);
	statsFrame.setLocation(1000,200);
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
	public void updateStats(){
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
	public void confirmStats(){
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
	public void genStats(){
		if(Class.equals("Rogue")){			
			str = d20.rollMinusLowest();
			con = d20.rollMinusLowest();
			dex = d20.rollMinusLowest()+mod.rollMinusLowest();
			Int = d20.rollMinusLowest();
			cha = d20.rollMinusLowest()+mod.rollMinusLowest();
			wis = d20.rollMinusLowest();
		}
		else if(Class.equals("Warrior")){
			str = d20.rollMinusLowest()+mod.rollMinusLowest();
			con = d20.rollMinusLowest()+mod.rollMinusLowest();
			dex = d20.rollMinusLowest();
			Int = d20.rollMinusLowest();
			cha = d20.rollMinusLowest();
			wis = d20.rollMinusLowest();
		}
		else if(Class.equals("Mage")){
			str = d20.rollMinusLowest();
			con = d20.rollMinusLowest();
			dex = d20.rollMinusLowest();
			Int = d20.rollMinusLowest()+mod.rollMinusLowest();
			cha = d20.rollMinusLowest();
			wis = d20.rollMinusLowest()+mod.rollMinusLowest();
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
		if(str>100)str=100;
		if(con>100)con=100;
		if(dex>100)dex=100;
		if(Int>100)Int=100;
		if(cha>100)cha=100;
		if(wis>100)wis=100;
		if(str==100&&con==100&&dex==100&&Int==100&&cha==100&&wis==100)lvl--;
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
public static void main(String[] args){
	Character chara = new Character();
	}
}
