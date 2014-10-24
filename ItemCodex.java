public class ItemCodex{
	String[] weaponType = {"dagger","sword","hand-axe","mace","longsword","great-sword","war-axe","warhammer","katana"};
	String[] weaponMaterial = {"broken","copper","iron","steel","mithril","glass","dwarven","enchanted","ancient","ash","beech","oak","elven","enchanted","ancient",""}; 
	String[] rngWeapon = {"shortbow", "crossbow", "long bow","composite bow","repeater crossbow","shuriken","throwing knife","poison dart","flint-lock pistol"};
	String[] specialWeapons = {"stick","spear","halberd","wrath's bane","fallen blade","end of night","edge of chaos","sword of the dweller","undying blade","blackDeath","deathSythe","sword of the mad god","Excalibur","god mode"};
	String[] rngXTRmaterials ={"iron","steel","mithril"};
	String[] armorMaterial = {"cloth","leather","chainMail","iron scale","plate iron","steel","glass","dwarven","ancient","enchanted"};
	String[] items = {"health potion","ankh","trinket"};
	String[] itemdes = {"a healing potion that restores some hit points","used to bring the dead back to life","a small piece of jewellery, it's probably worth a bit"};
	Dice D100 =new Dice(1,100);
	public ItemCodex(){
	}
	public void newItem(){
		int t = D100.roll();
		if(t<=33)armor();
		else if(t<=66)weapon();
		else if(t<=100)item();
	}
	public class Item{
		String name;
		String description;
		int value;
		int quantity = 0;
	}
	public void item(){}
	public class Weapon extends Item{
		int type;
		int mat;
		int mats;
		double matMult;
		double typeMult;
		int attack;
		int diceNo;
		int diceMax;
	}
	public class Armor extends Item{
		int AC;
		int mat;
		int mats;
	}
	public void weapon(){
		Weapon weapon = new Weapon();
		int wm = D100.roll();
		if(wm>95)weapon.mat = 15;//special
		else if(wm>90){weapon.mat = 14;weapon.matMult= 1.4;}//ancient r
		else if(wm>85){weapon.mat = 13;weapon.matMult= 1.3;}//enchanted r
		else if(wm>80){weapon.mat = 12;weapon.matMult= 2;}//elven
		else if(wm>75){weapon.mat = 11;weapon.matMult= 1.5;}//oak
		else if(wm>65){weapon.mat = 10;weapon.matMult= 1;}//beech
		else if(wm>60){weapon.mat = 9;weapon.matMult=0.5;}//ash
		else if(wm>55){weapon.mat = 8;weapon.matMult=1.5;}//ancient m
		else if(wm>50){weapon.mat = 7;weapon.matMult=1.4;}//enchanted m
		else if(wm>45){weapon.mat = 6;weapon.matMult=3.5;}//dwarven
		else if(wm>40){weapon.mat = 5;weapon.matMult=2.5;}//glass
		else if(wm>35){weapon.mat = 4;weapon.matMult=2;}//mithril
		else if(wm>30){weapon.mat = 3;weapon.matMult=1.5;}//steel
		else if(wm>15){weapon.mat = 2;weapon.matMult=1;}//iron 
		else if(wm>10){weapon.mat = 1;weapon.matMult=0.5;} //copper
		else{weapon.mat = 0;weapon.matMult=0.3;} //broken
		switch(weapon.mat){
			case(0):
				wm = D100.roll();
					if(wm>80){weapon.mats = 12;weapon.matMult *= 2;}//elven
					else if(wm>75){weapon.mats= 11;weapon.matMult *= 1.5;}// oak
					else if(wm>65){weapon.mats = 10;weapon.matMult *= 1;}//beech
					else if(wm>60){weapon.mats = 9;weapon.matMult *= 0.5;}//ash
					else if(wm>45){weapon.mats = 6;weapon.matMult *= 3.5;}//dwarven
					else if(wm>40){weapon.mats = 5;weapon.matMult *= 2.5;}//glass
					else if(wm>35){weapon.mats = 4;weapon.matMult *= 2;}//mithril
					else if(wm>30){weapon.mats = 3;weapon.matMult *= 1.5;}//steel
					else if(wm>25){weapon.mats = 2;weapon.matMult *= 1;}//iron 
					else{weapon.mat = 1;weapon.matMult*=0.5;} //copper
				break;
			case(7):
				wm = D100.roll();
					if(wm>80){weapon.mats = 6;weapon.matMult *= 3.5;}//dwarven
					else if(wm>70){weapon.mats = 5;weapon.matMult *= 2.5;}//glass
					else if(wm>50){weapon.mats = 4;weapon.matMult *= 2;}//mithril
					else if(wm>40){weapon.mats = 3;weapon.matMult *= 1.5;}//steel
					else if(wm>30){weapon.mats = 2;weapon.matMult *= 1;}//iron 
					else{weapon.mat = 1;weapon.matMult*=0.5;} //copper
				break;
			case(8):
				wm = D100.roll();
					if(wm>80){weapon.mats = 6;weapon.matMult *= 3.5;}//dwarven
					else if(wm>70){weapon.mats = 5;weapon.matMult *= 2.5;}//glass
					else if(wm>50){weapon.mats = 4;weapon.matMult *= 2;}//mithril
					else if(wm>40){weapon.mats = 3;weapon.matMult *= 1.5;}//steel
					else if(wm>30){weapon.mats = 2;weapon.matMult *= 1;}//iron 
					else{weapon.mat = 1;weapon.matMult*=0.5;} //copper
				break;
			case(13):
				wm = D100.roll();
					if(wm>75){weapon.mats = 12;weapon.matMult *= 2;}//elven
					else if(wm>50){weapon.mats= 11;weapon.matMult *= 1.5;}//oak
					else if(wm>25){weapon.mats = 10;weapon.matMult *= 1;}//beech
					else{weapon.mats = 9;weapon.matMult *= 0.5;}//ash
				break;
			case(14):
				wm = D100.roll();
					if(wm>75){weapon.mats = 12;weapon.matMult *= 2;}//elven
					else if(wm>50){weapon.mats= 11;weapon.matMult *= 1.5;}//oak
					else if(wm>25){weapon.mats = 10;weapon.matMult *= 1;}//beech
					else{weapon.mats = 9;weapon.matMult *= 0.5;}//ash
				break;
			default:
			break;
		}
		int td = D100.roll();
		if((weapon.mat==0&&weapon.mats<=6)||weapon.mat<=8){
			//weapontype[]
			if(weapon.mat>1||weapon.mats>1){	
				if(td > 95&&(weapon.mat>2||weapon.mats>2)){weapon.type=8;weapon.diceNo=17;weapon.diceMax=6;}//katana max DMG =102 w/o critical ancient dwarven katana=1785 dmg
				else if(td > 80){weapon.type=7;weapon.diceNo=10;weapon.diceMax=12;}//Warhammer max FMG w/o critical or multipliers = 120 ancient dwarven warhammer = 2100 dmg, dwawrven warhammer md = 420
				else if(td > 70){weapon.type=6;weapon.diceNo=7;weapon.diceMax=15;}//waraxe  max DMG W/o crit or multipliers = 105
				else if(td > 60){weapon.type=5;weapon.diceNo=6;weapon.diceMax=16;}//greatsword max DMG W/o crit or multipliers = 96
			}
			else if(td > 50){weapon.type=4;weapon.diceNo=5;weapon.diceMax=17;}//longsword max DMG W/o crit or multipliers = 85
			else if(td > 40){weapon.type=3;weapon.diceNo=4;weapon.diceMax=17;}//mace max DMG W/o crit or multipliers = 68
			else if(td > 30){weapon.type=2;weapon.diceNo=4;weapon.diceMax=15;}//hand axe  max DMG W/o crit or multipliers = 60
			else if(td > 10){weapon.type=1;weapon.diceNo=3;weapon.diceMax=16;}//sword max DMG W/o crit or multipliers = 48
			else{weapon.type=0;weapon.diceNo=1;weapon.diceMax=25;}// dagger dmg w/o multiplier or crit = 25 ancient dwarven dagger = 437.5 = 438
			if (weapon.mat<7&&weapon.mat !=0)weapon.name=(weaponMaterial[weapon.mat]+" "+weaponType[weapon.type]);
			else if(weapon.mat >=7 || weapon.mat == 0)weapon.name=(weaponMaterial[weapon.mat]+" "+weaponMaterial[weapon.mats]+" "+weaponType[weapon.type]);
		}
		else if(((weapon.mat==0&&weapon.mats>6)||weapon.mat>8)&& weapon.mat<15){
			//rngweapon[]
			if(td > 90){weapon.type=8;weapon.diceNo=1;weapon.diceMax=100;}//flintlock max dmg = 100 
			else if(td > 80){weapon.type=7;weapon.diceNo=4;weapon.diceMax=20;}//dart MD = 80
			else if(td > 70){weapon.type=6;weapon.diceNo=6;weapon.diceMax=15;}//knife MD= 90
			else if(td > 60){weapon.type=5;weapon.diceNo=10;weapon.diceMax=12;}//shuriken MD = 120 
			else if(td > 50){weapon.type=4;weapon.diceNo=5;weapon.diceMax=17;}//repeater crossbow = 85
			else if(td > 40){weapon.type=3;weapon.diceNo=2;weapon.diceMax=38;}//composite bow = 76
			else if(td > 30){weapon.type=2;weapon.diceNo=2;weapon.diceMax=30;}// longbow = 60
			else if(td > 20){weapon.type=1;weapon.diceNo=2;weapon.diceMax=20;}//crossbow = 40
			else{weapon.type=0;weapon.diceNo=2;weapon.diceMax=15;}//bow = 30
			if (weapon.mat<13&&weapon.mats !=0)weapon.name=(weaponMaterial[weapon.mat] +rngWeapon[weapon.type]);
			else if(weapon.mat >=7 || weapon.mat == 0)weapon.name=(weaponMaterial[weapon.mat]+" "+weaponMaterial[weapon.mats]+" "+rngWeapon[weapon.type]);
		}
		else if(weapon.mat==15){
		//special[]
			if(td > 99){weapon.type=13;weapon.diceNo=40;weapon.diceMax=999;}//godmode max dmg = 9999 (dmg%9999)
			else if(td > 97){weapon.type=12;weapon.diceNo=14;weapon.diceMax=200;}//Excalibur dmg=2800
			else if(td > 95){weapon.type=11;weapon.diceNo=10;weapon.diceMax=250;}//sword of the mad god MD = 2500
			else if(td > 92){weapon.type=10;weapon.diceNo=6;weapon.diceMax=300;}//deathSythe MD= 2400
			else if(td > 90){weapon.type=9;weapon.diceNo=10;weapon.diceMax=240;}//blackDeath MD = 2400
			else if(td > 87){weapon.type=8;weapon.diceNo=10;weapon.diceMax=220;}//undying blade MD = 2200
			else if(td > 84){weapon.type=7;weapon.diceNo=8;weapon.diceMax=250;}//sword of the dweller MD = 1900
			else if(td > 80){weapon.type=6;weapon.diceNo=9;weapon.diceMax=200;}//edge of chaos MD = 1800
			else if(td > 75){weapon.type=5;weapon.diceNo=8;weapon.diceMax=200;}//end of night MD = 1600
			else if(td > 70){weapon.type=4;weapon.diceNo=8;weapon.diceMax=175;}//fallen blade MD = 1400
			else if(td > 50){weapon.type=3;weapon.diceNo=8;weapon.diceMax=150;}//wrath's bane MD = 1200
			else if(td > 15){weapon.type=2;weapon.diceNo=5;weapon.diceMax=40;}//halberd= 200
			else if(td > 5){weapon.type=1;weapon.diceNo=5;weapon.diceMax=20;}//spear = 100
			else{weapon.type=0;weapon.diceNo=2;weapon.diceMax=10;}//stick = 20
			weapon.name= (specialWeapons[weapon.type]);
			weapon.matMult = 1;
		}
		System.out.print(weapon.name);
	}
	public void armor(){}
	public static void main(String[] args){
		ItemCodex item = new ItemCodex();
		item.weapon();
	}
}
/** broken, enchanted and ancient, apply to another weapon of the same type eg "ancient Iron longsword","encanted elven longbow","broken glass katana",
	enchanted should add another word instead of enchanted however same for special so "iron longsword of Death","excalibur",
	ranged weapons such as the pistol, throwing knifes, and shuriken will have diffrent material names, iron steel mithril'
	also mindmg = (matmult-1)*dicemax; matmult before enchanted or ancient multiplier, for special Weapons it varies 
	 **/
