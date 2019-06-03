/* $$ This file has been instrumented by Clover 4.1.2#20161011084623935 $$ */package kavicsos_jatek.kavics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Ez az oszt\u00e1ly felel a szab\u00e1lyok megjelen\u00edt\u00e9s\u00e9\u00e9rt.
 *  
 * @see kavicsos_jatek.kavics
 */
public class szabalyok implements MouseListener {public static class __CLR4_1_29l9ljvr2kze3{public static com_atlassian_clover.CoverageRecorder R;public static com_atlassian_clover.CloverProfile[] profiles = { };@java.lang.SuppressWarnings("unchecked") public static <I, T extends I> I lambdaInc(final int i,final T l,final int si){java.lang.reflect.InvocationHandler h=new java.lang.reflect.InvocationHandler(){public java.lang.Object invoke(java.lang.Object p,java.lang.reflect.Method m,java.lang.Object[] a) throws Throwable{R.inc(i);R.inc(si);try{return m.invoke(l,a);}catch(java.lang.reflect.InvocationTargetException e){throw e.getCause()!=null?e.getCause():new RuntimeException("Clover failed to invoke instrumented lambda",e);}}};return (I)java.lang.reflect.Proxy.newProxyInstance(l.getClass().getClassLoader(),l.getClass().getInterfaces(),h);}static{com_atlassian_clover.CoverageRecorder _R=null;try{com_atlassian_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___4_1_2();if(20161011084623935L!=com_atlassian_clover.CloverVersionInfo.getBuildStamp()){com_atlassian_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_atlassian_clover.Clover.l("[CLOVER] WARNING: Instr=4.1.2#20161011084623935,Runtime="+com_atlassian_clover.CloverVersionInfo.getReleaseNum()+"#"+com_atlassian_clover.CloverVersionInfo.getBuildStamp());}R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getRecorder("\u0043\u003a\u005c\u005c\u0055\u0073\u0065\u0072\u0073\u005c\u005c\u006a\u0075\u0073\u007a\u0074\u005c\u005c\u0044\u0065\u0073\u006b\u0074\u006f\u0070\u005c\u005c\u0034\u0078\u0034\u0047\u0041\u004d\u0045\u002d\u004a\u0075\u0073\u007a\u0074\u0069\u006e\u006e\u005c\u005c\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1558036293852L,8589935092L,389,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}public static final com_atlassian_clover.TestNameSniffer __CLR4_1_2_TEST_NAME_SNIFFER=com_atlassian_clover.TestNameSniffer.NULL_INSTANCE;
	/**
	 * Seg\u00edts\u00e9g\u00e9vel megvizsg\u00e1ljuk a k\u00e9perny\u0151 m\u00e9ret\u00e9t.
	 */
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	/**
	 * Grafikus fel\u00fclet kirajzol\u00e1s\u00e1hoz haszn\u00e1ljuk.
	 */
	Drawing draw = new Drawing();
	/**
	 * Ablak c\u00edmsor\u00e1nak elnevez\u00e9s\u00e9re haszn\u00e1ljuk.
	 */
	JFrame szabaly = new JFrame("4x4 kavics j\u00e1t\u00e9k - szab\u00e1lyok");
	/**
	 * \u00dczenet megjelen\u00edt\u00e9s\u00e9re szolg\u00e1l a j\u00e1t\u00e9kosok sz\u00e1m\u00e1ra.
	 */
	JLabel uzenet = new JLabel("Olvasd el a szab\u00e1lyzatot figyelmesen!");
	/**
	 * Vissza gombhoz v\u00e1ltoz\u00f3 deklar\u00e1l\u00e1s.
	 */
	ImageIcon visszagomb;
	/**
	 * H\u00e1tt\u00e9rk\u00e9phez v\u00e1ltoz\u00f3 deklar\u00e1l\u00e1s.
	 */
	ImageIcon hatter;
	/**
	 * Start gombhoz v\u00e1ltoz\u00f3 deklar\u00e1l\u00e1s.
	 */
	ImageIcon elsomenu;
	/**
	 * Szab\u00e1lyok gombhoz v\u00e1ltoz\u00f3 deklar\u00e1l\u00e1s.
	 */
	ImageIcon szabalyok;
	/**
	 * El\u0151zm\u00e9nyek gombhoz v\u00e1ltoz\u00f3 deklar\u00e1l\u00e1s.
	 */
	ImageIcon harmadikmenu;

	/**
	 * Ablak megjelen\u00edt\u00e9s\u00e9t szolg\u00e1lja.
	 *  
	 * @see kavicsos_jatek.kavics
	 */
	public szabalyok() {try{__CLR4_1_29l9ljvr2kze3.R.inc(345);
		
		__CLR4_1_29l9ljvr2kze3.R.inc(346);hatter = new ImageIcon(getClass().getClassLoader().getResource("hatter_2.jpg"));
		__CLR4_1_29l9ljvr2kze3.R.inc(347);elsomenu = new ImageIcon(getClass().getClassLoader().getResource("start-gomb.jpg"));
		__CLR4_1_29l9ljvr2kze3.R.inc(348);harmadikmenu = new ImageIcon(getClass().getClassLoader().getResource("elozo-gomb.jpg"));
		__CLR4_1_29l9ljvr2kze3.R.inc(349);szabalyok = new ImageIcon(getClass().getClassLoader().getResource("szabalyzat.jpg"));
		__CLR4_1_29l9ljvr2kze3.R.inc(350);visszagomb = new ImageIcon(getClass().getClassLoader().getResource("visszagomb.png"));
		__CLR4_1_29l9ljvr2kze3.R.inc(351);szabaly.add(draw);
		__CLR4_1_29l9ljvr2kze3.R.inc(352);draw.addMouseListener(this);
		__CLR4_1_29l9ljvr2kze3.R.inc(353);szabaly.setSize(800, 600);
		__CLR4_1_29l9ljvr2kze3.R.inc(354);szabaly.setLocation(dim.width/2-szabaly.getSize().width/2, dim.height/2-szabaly.getSize().height/2);
		__CLR4_1_29l9ljvr2kze3.R.inc(355);uzenet.setFont(new Font("Serif", Font.BOLD, 20));
		__CLR4_1_29l9ljvr2kze3.R.inc(356);uzenet.setForeground(Color.black);
		__CLR4_1_29l9ljvr2kze3.R.inc(357);uzenet.setHorizontalAlignment(SwingConstants.CENTER);
		__CLR4_1_29l9ljvr2kze3.R.inc(358);szabaly.add(uzenet, "South");
		__CLR4_1_29l9ljvr2kze3.R.inc(359);szabaly.setVisible(true);
	}finally{__CLR4_1_29l9ljvr2kze3.R.flushNeeded();}}

	/**
	 * A h\u00e1tt\u00e9rk\u00e9p \u00e9s a men\u00fcpontok elhelyez\u00e9s\u00e9re szolg\u00e1l az ablakban.
	 *
	 */
	class Drawing extends JComponent {
		public void paint(Graphics g) {try{__CLR4_1_29l9ljvr2kze3.R.inc(360);
			__CLR4_1_29l9ljvr2kze3.R.inc(361);Graphics2D g2 = (Graphics2D) g;
			__CLR4_1_29l9ljvr2kze3.R.inc(362);g.drawImage(hatter.getImage(), 0, 0, this);
			__CLR4_1_29l9ljvr2kze3.R.inc(363);g.drawImage(elsomenu.getImage(), 75, 425, this);
			__CLR4_1_29l9ljvr2kze3.R.inc(364);g.drawImage(visszagomb.getImage(), 0, 0, this);
			__CLR4_1_29l9ljvr2kze3.R.inc(365);g.drawImage(szabalyok.getImage(), 100, 175, this);
			__CLR4_1_29l9ljvr2kze3.R.inc(366);g.drawImage(harmadikmenu.getImage(), 425, 425, this);
		}finally{__CLR4_1_29l9ljvr2kze3.R.flushNeeded();}}
	}
	
	public void mousePressed(MouseEvent e) {try{__CLR4_1_29l9ljvr2kze3.R.inc(367);
	}finally{__CLR4_1_29l9ljvr2kze3.R.flushNeeded();}}

	/**
	 * Eg\u00e9r kattint\u00e1sok \u00e9rz\u00e9kel\u00e9s\u00e9re \u00e9s kezel\u00e9s\u00e9re szolg\u00e1l.
	 * Men\u00fcpontokra kattintva az megfelel\u0151 esem\u00e9nyt hajtja v\u00e9gre.
	 */
	public void mouseReleased(MouseEvent e) {try{__CLR4_1_29l9ljvr2kze3.R.inc(368);
		__CLR4_1_29l9ljvr2kze3.R.inc(369);int row = e.getX();
		__CLR4_1_29l9ljvr2kze3.R.inc(370);int col = e.getY();
		__CLR4_1_29l9ljvr2kze3.R.inc(371);if ((((row >= 1 && row <= 40 && col >= 0 && col <= 40)&&(__CLR4_1_29l9ljvr2kze3.R.iget(372)!=0|true))||(__CLR4_1_29l9ljvr2kze3.R.iget(373)==0&false)))
			{{
			__CLR4_1_29l9ljvr2kze3.R.inc(374);szabaly.dispose();
			__CLR4_1_29l9ljvr2kze3.R.inc(375);new kezdokepernyo();
			}
		}__CLR4_1_29l9ljvr2kze3.R.inc(376);if ((((row >= 75 && row <= 375 && col >= 425 && col <= 505)&&(__CLR4_1_29l9ljvr2kze3.R.iget(377)!=0|true))||(__CLR4_1_29l9ljvr2kze3.R.iget(378)==0&false)))
			{{
			__CLR4_1_29l9ljvr2kze3.R.inc(379);szabaly.dispose();
			__CLR4_1_29l9ljvr2kze3.R.inc(380);new jatekablak();
			}
		}__CLR4_1_29l9ljvr2kze3.R.inc(381);if ((((row >= 425 && row <= 725 && col >= 425 && col <= 505)&&(__CLR4_1_29l9ljvr2kze3.R.iget(382)!=0|true))||(__CLR4_1_29l9ljvr2kze3.R.iget(383)==0&false)))
			{{
			__CLR4_1_29l9ljvr2kze3.R.inc(384);szabaly.dispose();
			__CLR4_1_29l9ljvr2kze3.R.inc(385);new elozmenyek();
			}
	}}finally{__CLR4_1_29l9ljvr2kze3.R.flushNeeded();}}

	public void mouseClicked(MouseEvent e) {try{__CLR4_1_29l9ljvr2kze3.R.inc(386);
	}finally{__CLR4_1_29l9ljvr2kze3.R.flushNeeded();}}

	public void mouseEntered(MouseEvent e) {try{__CLR4_1_29l9ljvr2kze3.R.inc(387);
	}finally{__CLR4_1_29l9ljvr2kze3.R.flushNeeded();}}

	public void mouseExited(MouseEvent e) {try{__CLR4_1_29l9ljvr2kze3.R.inc(388);
	}finally{__CLR4_1_29l9ljvr2kze3.R.flushNeeded();}}
}