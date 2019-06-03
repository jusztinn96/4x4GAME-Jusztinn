/* $$ This file has been instrumented by Clover 4.3.1#20180921211537623 $$ */package kavicsos_jatek.kavics;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Ez az oszt\u00e1ly felel a j\u00e1t\u00e9kt\u00e1bla megjelen\u00edt\u00e9s\u00e9\u00e9rt.
 *  
 * @see kavicsos_jatek.kavics
 */
public class jatekablak implements KeyListener, MouseListener {public static class __CLR4_3_1fafajvr3r80r{public static com_atlassian_clover.CoverageRecorder R;public static com_atlassian_clover.CloverProfile[] profiles = { };@java.lang.SuppressWarnings("unchecked") public static <I, T extends I> I lambdaInc(final int i,final T l,final int si){java.lang.reflect.InvocationHandler h=new java.lang.reflect.InvocationHandler(){public java.lang.Object invoke(java.lang.Object p,java.lang.reflect.Method m,java.lang.Object[] a) throws Throwable{R.inc(i);R.inc(si);try{return m.invoke(l,a);}catch(java.lang.reflect.InvocationTargetException e){throw e.getCause()!=null?e.getCause():new RuntimeException("Clover failed to invoke instrumented lambda",e);}}};return (I)java.lang.reflect.Proxy.newProxyInstance(l.getClass().getClassLoader(),l.getClass().getInterfaces(),h);}static{com_atlassian_clover.CoverageRecorder _R=null;try{com_atlassian_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___4_3_1();if(20180921211537623L!=com_atlassian_clover.CloverVersionInfo.getBuildStamp()){com_atlassian_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_atlassian_clover.Clover.l("[CLOVER] WARNING: Instr=4.3.1#20180921211537623,Runtime="+com_atlassian_clover.CloverVersionInfo.getReleaseNum()+"#"+com_atlassian_clover.CloverVersionInfo.getBuildStamp());}R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getRecorder("\u0043\u003a\u005c\u005c\u0055\u0073\u0065\u0072\u0073\u005c\u005c\u006a\u0075\u0073\u007a\u0074\u005c\u005c\u0044\u0065\u0073\u006b\u0074\u006f\u0070\u005c\u005c\u0034\u0078\u0034\u0047\u0041\u004d\u0045\u002d\u004a\u0075\u0073\u007a\u0074\u0069\u006e\u006e\u005c\u005c\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1558038264901L,8589935092L,815,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}public static final com_atlassian_clover.TestNameSniffer __CLR4_3_1_TEST_NAME_SNIFFER=com_atlassian_clover.TestNameSniffer.NULL_INSTANCE;
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
	JFrame jatek = new JFrame("4x4 kavics j\u00e1t\u00e9k - j\u00e1t\u00e9kterep");
	/**
	 * A fajl megmutatja, hogy az XML f\u00e1jl, melyben az adatok t\u00e1rol\u00e1sra ker\u00fclnek, l\u00e9tezik-e?
	 */
	static boolean fajl;
	/**
	 * x,y v\u00e1ltoz\u00f3kat ciklusokhoz haszn\u00e1ljuk fel.
	 * sor, oszlop, sor2, oszlop2, sor3, oszlop3 v\u00e1ltoz\u00f3kat a szomsz\u00e9dos sorok elt\u00e1rol\u00e1s\u00e1ra haszn\u00e1ljuk egy-egy k\u00f6r sor\u00e1n.
	 */
	int x, y, szamlalo=0, sor, oszlop, sor2, oszlop2, sor3, oszlop3;
	/**
	 * A t\u00f6mb j\u00e1t\u00e9kt\u00e1bla mez\u0151inek elt\u00e1rol\u00e1s\u00e1ra szolg\u00e1l (4x4).
	 */
	int[][] board = new int[4][4];
	/**
	 * Ezen v\u00e1ltoz\u00f3t seg\u00edts\u00e9g\u00e9vel tartjuk sz\u00e1mon, hogy \u00e9ppen melyik j\u00e1t\u00e9kos k\u00f6vetkezik. Kezd\u0151\u00e9rt\u00e9ke 1, mely az el\u0151 j\u00e1t\u00e9kos.
	 */
	int xTurn = (1);
	/**
	 * \u00dczenet megjelen\u00edt\u00e9s\u00e9re szolg\u00e1l a j\u00e1t\u00e9kosok sz\u00e1m\u00e1ra.
	 */
	JLabel message = new JLabel("1. j\u00e1t\u00e9kos l\u00e9p - z\u00f6ld");
	/**
	 * Ez a t\u00f6mb a v\u00e1ltoz\u00f3 k\u00e9pek elt\u00e1rol\u00e1s\u00e1ra szolg\u00e1l.
	 */
	ImageIcon[] boardPictures = new ImageIcon[3];
	/**
	 * \u00dczenet megjelen\u00edt\u00e9s\u00e9t szolg\u00e1lja a j\u00e1t\u00e9k v\u00e9g\u00e9n.
	 */
	String uzenet;
	/**
	 * Az XML dokumentumban a nyertes j\u00e1t\u00e9kos elt\u00e1rol\u00e1s\u00e1ra szolg\u00e1l.
	 */
	static String nyertes;
	/**
	 * Az XML dokumentumban a m\u00e9rk\u0151z\u00e9s befejez\u00e9s\u00e9nek d\u00e1tum\u00e1t t\u00e1rolja el.
	 */
	static String pontosdatum;
	/**
	 * Az XML f\u00e1jlra ezen v\u00e1ltoz\u00f3 seg\u00edts\u00e9g\u00e9vel hivatkozunk.
	 */
	static File fjl = null;

	/**
	 * Ablak megjelen\u00edt\u00e9s\u00e9t szolg\u00e1lja.
	 *  
	 * @see kavicsos_jatek.kavics
	 */
	
	static int mezok;
	
	public jatekablak() 
	{try{__CLR4_3_1fafajvr3r80r.R.inc(550);
		__CLR4_3_1fafajvr3r80r.R.inc(551);for (int i = 0; (((i < boardPictures.length)&&(__CLR4_3_1fafajvr3r80r.R.iget(552)!=0|true))||(__CLR4_3_1fafajvr3r80r.R.iget(553)==0&false)); i++)
			{__CLR4_3_1fafajvr3r80r.R.inc(554);boardPictures[i] = new ImageIcon(getClass().getClassLoader().getResource(i + ".jpg"));
		}__CLR4_3_1fafajvr3r80r.R.inc(555);jatek.add(draw);
		__CLR4_3_1fafajvr3r80r.R.inc(556);jatek.addKeyListener(this);
		__CLR4_3_1fafajvr3r80r.R.inc(557);jatek.addMouseListener(this);
		__CLR4_3_1fafajvr3r80r.R.inc(558);jatek.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		__CLR4_3_1fafajvr3r80r.R.inc(559);jatek.setSize(800, 600);
		__CLR4_3_1fafajvr3r80r.R.inc(560);jatek.setLocation(dim.width/2-jatek.getSize().width/2, dim.height/2-jatek.getSize().height/2);
		__CLR4_3_1fafajvr3r80r.R.inc(561);message.setFont(new Font("Serif", Font.BOLD, 20));
		__CLR4_3_1fafajvr3r80r.R.inc(562);message.setForeground(Color.blue);
		__CLR4_3_1fafajvr3r80r.R.inc(563);message.setHorizontalAlignment(SwingConstants.CENTER);
		__CLR4_3_1fafajvr3r80r.R.inc(564);jatek.add(message, "South");
		__CLR4_3_1fafajvr3r80r.R.inc(565);jatek.setVisible(true);
	}finally{__CLR4_3_1fafajvr3r80r.R.flushNeeded();}}
	
	/**
	 * Napl\u00f3z\u00e1si met\u00f3dus
	 */
	private static final Logger logger = LoggerFactory.getLogger(jatekablak.class);

	/**
	 * Ezen logikai v\u00e1ltoz\u00f3 seg\u00edts\u00e9g\u00e9vel vizsg\u00e1ljuk meg, hogy \u00fcres-e a t\u00e1bla, azaz nincs m\u00e1r rajta egy kavics sem.
	 *  
	 * @return A t\u00e1bla \u00fcres, azaz nincs rajta egy kavics sem.
	 */
	public boolean fullBoard() 
	{try{__CLR4_3_1fafajvr3r80r.R.inc(566);
		/**
		* Ezen v\u00e1ltoz\u00f3 seg\u00edts\u00e9g\u00e9vel tartjuk sz\u00e1mon, hogy h\u00e1ny mez\u0151n nincs m\u00e1r kavics, azaz h\u00e1ny mez\u0151 \u00fcres.
		*/
		__CLR4_3_1fafajvr3r80r.R.inc(567);int countBlank = 0;
		__CLR4_3_1fafajvr3r80r.R.inc(568);for (int r = 0; (((r < 4)&&(__CLR4_3_1fafajvr3r80r.R.iget(569)!=0|true))||(__CLR4_3_1fafajvr3r80r.R.iget(570)==0&false)); r++) {{
			__CLR4_3_1fafajvr3r80r.R.inc(571);for (int col = 0; (((col < 4)&&(__CLR4_3_1fafajvr3r80r.R.iget(572)!=0|true))||(__CLR4_3_1fafajvr3r80r.R.iget(573)==0&false)); col++) {{
				__CLR4_3_1fafajvr3r80r.R.inc(574);if ((((board[r][col] == 0)&&(__CLR4_3_1fafajvr3r80r.R.iget(575)!=0|true))||(__CLR4_3_1fafajvr3r80r.R.iget(576)==0&false)))
					{__CLR4_3_1fafajvr3r80r.R.inc(577);countBlank++;
			}}
		}}
		}__CLR4_3_1fafajvr3r80r.R.inc(578);return (countBlank == 0);
	}finally{__CLR4_3_1fafajvr3r80r.R.flushNeeded();}}
	
	/**
	 * Megsz\u00e1molja, hogy a t\u00e1bl\u00e1nk val\u00f3ban 4x4 mez\u0151b\u0151l \u00e1ll
	 * @return Mez\u0151k darabsz\u00e1ma
	 */
	int mezok_ellenorzese() 
	{try{__CLR4_3_1fafajvr3r80r.R.inc(579);
		/**
		* Ezen v\u00e1ltoz\u00f3 seg\u00edts\u00e9g\u00e9vel tartjuk sz\u00e1mon, hogy h\u00e1ny mez\u0151t sz\u00e1moltunk m\u00e1r meg.
		*/
		__CLR4_3_1fafajvr3r80r.R.inc(580);mezok = 0;
		__CLR4_3_1fafajvr3r80r.R.inc(581);for (int r = 0; (((r < 4)&&(__CLR4_3_1fafajvr3r80r.R.iget(582)!=0|true))||(__CLR4_3_1fafajvr3r80r.R.iget(583)==0&false)); r++) {{
			__CLR4_3_1fafajvr3r80r.R.inc(584);for (int col = 0; (((col < 4)&&(__CLR4_3_1fafajvr3r80r.R.iget(585)!=0|true))||(__CLR4_3_1fafajvr3r80r.R.iget(586)==0&false)); col++) {{
				__CLR4_3_1fafajvr3r80r.R.inc(587);if ((((board[r][col] == 1)&&(__CLR4_3_1fafajvr3r80r.R.iget(588)!=0|true))||(__CLR4_3_1fafajvr3r80r.R.iget(589)==0&false)))
					{__CLR4_3_1fafajvr3r80r.R.inc(590);mezok++;
			}}
		}}
		}__CLR4_3_1fafajvr3r80r.R.inc(591);return (mezok);
	}finally{__CLR4_3_1fafajvr3r80r.R.flushNeeded();}}
	
	/**
	 * Az XML f\u00e1jlkezel\u00e9sre szolg\u00e1l.
	 * Ha az XML f\u00e1jl nem l\u00e9tezik, akkor l\u00e9trehoz egyet \u00e9s bele\u00edrja a legut\u00f3bbi eredm\u00e9nyt.
	 * Ha l\u00e9tezik az XML f\u00e1jl, akkor hozz\u00e1f\u0171zi a legut\u00f3bbi eredm\u00e9nyt a f\u00e1jlhoz.
	 */
	public void fajlkezeles() {try{__CLR4_3_1fafajvr3r80r.R.inc(592);
		__CLR4_3_1fafajvr3r80r.R.inc(593);fjl = new File(getClass().getClassLoader().getResource("ered.xml").getFile());
		__CLR4_3_1fafajvr3r80r.R.inc(594);fajl = fjl.exists();
		__CLR4_3_1fafajvr3r80r.R.inc(595);if ((((!fajl)&&(__CLR4_3_1fafajvr3r80r.R.iget(596)!=0|true))||(__CLR4_3_1fafajvr3r80r.R.iget(597)==0&false)))
		{{
        __CLR4_3_1fafajvr3r80r.R.inc(598);DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
        __CLR4_3_1fafajvr3r80r.R.inc(599);DocumentBuilder icBuilder;
        __CLR4_3_1fafajvr3r80r.R.inc(600);try {
            __CLR4_3_1fafajvr3r80r.R.inc(601);icBuilder = icFactory.newDocumentBuilder();
            __CLR4_3_1fafajvr3r80r.R.inc(602);Document doc = icBuilder.newDocument();
            __CLR4_3_1fafajvr3r80r.R.inc(603);Element mainRootElement = doc.createElement("M\u00e9rk\u0151z\u00e9sek");
            __CLR4_3_1fafajvr3r80r.R.inc(604);doc.appendChild(mainRootElement);
 
            __CLR4_3_1fafajvr3r80r.R.inc(605);mainRootElement.appendChild(jatszmak(doc, nyertes, pontosdatum));
 
            __CLR4_3_1fafajvr3r80r.R.inc(606);Transformer transformer = TransformerFactory.newInstance().newTransformer();
            __CLR4_3_1fafajvr3r80r.R.inc(607);DOMSource source = new DOMSource(doc);
            __CLR4_3_1fafajvr3r80r.R.inc(608);StreamResult result = new StreamResult(new File(getClass().getClassLoader().getResource("ered.xml").getFile()));
            __CLR4_3_1fafajvr3r80r.R.inc(609);transformer.transform(source, result);
 
            __CLR4_3_1fafajvr3r80r.R.inc(610);logger.info("XML f\u00e1jl l\u00e9trehozva.");
 
        	} 	
        	catch (Exception e) {
            __CLR4_3_1fafajvr3r80r.R.inc(611);e.printStackTrace();
        	}
		}
		}else
		{{
			
			__CLR4_3_1fafajvr3r80r.R.inc(612);try {
			__CLR4_3_1fafajvr3r80r.R.inc(613);DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			__CLR4_3_1fafajvr3r80r.R.inc(614);DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			__CLR4_3_1fafajvr3r80r.R.inc(615);Document doc = docBuilder.parse(fjl);
			__CLR4_3_1fafajvr3r80r.R.inc(616);Element root = doc.getDocumentElement();

            __CLR4_3_1fafajvr3r80r.R.inc(617);root.appendChild(jatszmak(doc, nyertes, pontosdatum));

            __CLR4_3_1fafajvr3r80r.R.inc(618);TransformerFactory transformerFactory = TransformerFactory.newInstance();
            __CLR4_3_1fafajvr3r80r.R.inc(619);Transformer transformer = transformerFactory.newTransformer();
            __CLR4_3_1fafajvr3r80r.R.inc(620);DOMSource source = new DOMSource(doc);
            __CLR4_3_1fafajvr3r80r.R.inc(621);StreamResult result = new StreamResult(new File(getClass().getClassLoader().getResource("ered.xml").getFile()));
            __CLR4_3_1fafajvr3r80r.R.inc(622);transformer.transform(source, result);
            
            __CLR4_3_1fafajvr3r80r.R.inc(623);logger.info("XML f\u00e1jl sikeresen m\u00f3dos\u00edtva.");
            
			}
			catch (Exception e) {
	        __CLR4_3_1fafajvr3r80r.R.inc(624);e.printStackTrace();
	        }
		}
    }}finally{__CLR4_3_1fafajvr3r80r.R.flushNeeded();}}
 
	/**
	 * 
	 * @param doc Az XML dokumentum.
	 * @param name Nyertes elt\u00e1rol\u00e1s\u00e1ra szolg\u00e1l.
	 * @param date A j\u00e1t\u00e9k befejez\u00e9s\u00e9nek pontos ideje.
	 * @return J\u00e1tszma tag \u00e9s a benne l\u00e9v\u0151 nyertes neve \u00e9s a j\u00e1tszma ideje.
	 */
    private static Node jatszmak(Document doc, String name, String date) {try{__CLR4_3_1fafajvr3r80r.R.inc(625);
        __CLR4_3_1fafajvr3r80r.R.inc(626);Element jatszma = doc.createElement("J\u00e1tszma");
        __CLR4_3_1fafajvr3r80r.R.inc(627);jatszma.appendChild(jatszmaelem(doc, jatszma, "Nyertes", name));
        __CLR4_3_1fafajvr3r80r.R.inc(628);jatszma.appendChild(jatszmaelem(doc, jatszma, "D\u00e1tum", date));
        __CLR4_3_1fafajvr3r80r.R.inc(629);return jatszma;
    }finally{__CLR4_3_1fafajvr3r80r.R.flushNeeded();}}
    
    /**
     * 
     * @param doc Az XML dokumentum.
     * @param element Az XML dokumentum adott eleme.
     * @param name Elemn\u00e9v.
     * @param value \u00c9rt\u00e9k hozz\u00e1ad\u00e1sa az adott elemhez.
     * @return J\u00e1tszam elemei.
     */
 
    private static Node jatszmaelem(Document doc, Element element, String name, String value) {try{__CLR4_3_1fafajvr3r80r.R.inc(630);
        __CLR4_3_1fafajvr3r80r.R.inc(631);Element node = doc.createElement(name);
        __CLR4_3_1fafajvr3r80r.R.inc(632);node.appendChild(doc.createTextNode(value));
        __CLR4_3_1fafajvr3r80r.R.inc(633);return node;
    }finally{__CLR4_3_1fafajvr3r80r.R.flushNeeded();}}
    
    /**
     * A m\u00e9rk\u0151z\u00e9s befejez\u00e9s\u00e9nek ideje.
     */
    public void datum()
    {try{__CLR4_3_1fafajvr3r80r.R.inc(634);
		__CLR4_3_1fafajvr3r80r.R.inc(635);Date dNow = new Date( );
		__CLR4_3_1fafajvr3r80r.R.inc(636);SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd. HH:mm:ss");
		__CLR4_3_1fafajvr3r80r.R.inc(637);pontosdatum = ft.format(dNow);
    }finally{__CLR4_3_1fafajvr3r80r.R.flushNeeded();}}
    
    /**
     * A j\u00e1t\u00e9k v\u00e9ge t\u00e9r\u00e9se ut\u00e1ni feladatok elv\u00e9gz\u00e9s\u00e9re szolg\u00e1l.
     * Megadja a nyertes nev\u00e9t, a befejez\u00e9s d\u00e1tum\u00e1t.
     * Elind\u00edtja a f\u00e1jlkezel\u00e9st.
     * Felugr\u00f3 ablakban k\u00f6zli a j\u00e1t\u00e9k v\u00e9g\u00e9t.
     * Bez\u00e1rja a j\u00e1t\u00e9kteret \u00e9s visszair\u00e1ny\u00edt a kezd\u0151k\u00e9perny\u0151re.
     */
	
	public void jatekvege()
	{try{__CLR4_3_1fafajvr3r80r.R.inc(638);
		__CLR4_3_1fafajvr3r80r.R.inc(639);datum();
		__CLR4_3_1fafajvr3r80r.R.inc(640);if ((((xTurn == (1))&&(__CLR4_3_1fafajvr3r80r.R.iget(641)!=0|true))||(__CLR4_3_1fafajvr3r80r.R.iget(642)==0&false))) {{__CLR4_3_1fafajvr3r80r.R.inc(643);uzenet = "2. j\u00e1t\u00e9kos (piros) nyert! Eredm\u00e9nyek elmentve."; __CLR4_3_1fafajvr3r80r.R.inc(644);nyertes ="2. j\u00e1t\u00e9kos (piros)";}
		}__CLR4_3_1fafajvr3r80r.R.inc(645);if ((((xTurn == (-1))&&(__CLR4_3_1fafajvr3r80r.R.iget(646)!=0|true))||(__CLR4_3_1fafajvr3r80r.R.iget(647)==0&false))) {{__CLR4_3_1fafajvr3r80r.R.inc(648);uzenet = "1. j\u00e1t\u00e9kos (z\u00f6ld) nyert! Eredm\u00e9nyek elmentve."; __CLR4_3_1fafajvr3r80r.R.inc(649);nyertes ="1. j\u00e1t\u00e9kos (z\u00f6ld)";}
		}__CLR4_3_1fafajvr3r80r.R.inc(650);fajlkezeles();
		__CLR4_3_1fafajvr3r80r.R.inc(651);JOptionPane.showMessageDialog(null, uzenet , "Eredm\u00e9ny", JOptionPane.INFORMATION_MESSAGE);
		__CLR4_3_1fafajvr3r80r.R.inc(652);jatek.dispose();
		__CLR4_3_1fafajvr3r80r.R.inc(653);new kezdokepernyo();
	}finally{__CLR4_3_1fafajvr3r80r.R.flushNeeded();}}
	
	/**
	 * Az els\u0151 j\u00e1t\u00e9kos egy k\u00f6r\u00e9t kezeli.
	 * V\u00e9get \u00e9r, ha a maxim\u00e1lis 4 l\u00e9p\u00e9st el\u00e9ri vagy SPACE gombbal nem t\u00f6rt\u00e9nik v\u00e1lt\u00e1s.
	 * K\u00f6rben minden l\u00e9p\u00e9s ut\u00e1n vizsg\u00e1ljuk, hogy a t\u00e1bl\u00e1n van-e m\u00e9g kavics.
	 * Figyel\u00fcnk arra, hogy egy k\u00f6rben csak a mellette l\u00e9v\u0151 kavicsot lehet levenni.
	 * @param row A t\u00e1bla mez\u0151i.
	 * @param col A t\u00e1bla sorai.
	 */
	public void elso (int row, int col) {try{__CLR4_3_1fafajvr3r80r.R.inc(654);
		
			__CLR4_3_1fafajvr3r80r.R.inc(655);if (((((board[row][col] == 0) && (szamlalo == 0))&&(__CLR4_3_1fafajvr3r80r.R.iget(656)!=0|true))||(__CLR4_3_1fafajvr3r80r.R.iget(657)==0&false)))
			{{
				__CLR4_3_1fafajvr3r80r.R.inc(658);board[row][col] = 1;
				__CLR4_3_1fafajvr3r80r.R.inc(659);sor=row;
				__CLR4_3_1fafajvr3r80r.R.inc(660);oszlop=col;
				__CLR4_3_1fafajvr3r80r.R.inc(661);szamlalo ++;
				__CLR4_3_1fafajvr3r80r.R.inc(662);draw.repaint();
			}
			
			}__CLR4_3_1fafajvr3r80r.R.inc(663);if (((((board[row][col] == 0) && (szamlalo == 1) && ((((row == sor) && ((col-oszlop==1) || (col-oszlop==-1))) || (((col==oszlop) && ((row-sor==1) || (row-sor==-1)))))))&&(__CLR4_3_1fafajvr3r80r.R.iget(664)!=0|true))||(__CLR4_3_1fafajvr3r80r.R.iget(665)==0&false)))
			{{
				__CLR4_3_1fafajvr3r80r.R.inc(666);board[row][col] = 1;
				__CLR4_3_1fafajvr3r80r.R.inc(667);sor2=row;
				__CLR4_3_1fafajvr3r80r.R.inc(668);oszlop2=col;
				__CLR4_3_1fafajvr3r80r.R.inc(669);szamlalo ++;
				__CLR4_3_1fafajvr3r80r.R.inc(670);draw.repaint();
				
			}
			
			}__CLR4_3_1fafajvr3r80r.R.inc(671);if (((((board[row][col] == 0) && (szamlalo == 2) && 
					((((row == sor) && ((col-oszlop==1) || (col-oszlop==-1))) || (((col==oszlop) && ((row-sor==1) || (row-sor==-1))))) 
					||
					(((row == sor2) && ((col-oszlop2==1) || (col-oszlop2==-1))) || (((col==oszlop2) && ((row-sor2==1) || (row-sor2==-1)))))))&&(__CLR4_3_1fafajvr3r80r.R.iget(672)!=0|true))||(__CLR4_3_1fafajvr3r80r.R.iget(673)==0&false)))
			{{
				__CLR4_3_1fafajvr3r80r.R.inc(674);board[row][col] = 1;
				__CLR4_3_1fafajvr3r80r.R.inc(675);sor3=row;
				__CLR4_3_1fafajvr3r80r.R.inc(676);oszlop3=col;
				__CLR4_3_1fafajvr3r80r.R.inc(677);szamlalo ++;
				__CLR4_3_1fafajvr3r80r.R.inc(678);draw.repaint();
			}
			
			}__CLR4_3_1fafajvr3r80r.R.inc(679);if (((((board[row][col] == 0) && (szamlalo == 3) &&
					((((row == sor) && ((col-oszlop==1) || (col-oszlop==-1))) || (((col==oszlop) && ((row-sor==1) || (row-sor==-1))))) 
					|| 
					(((row == sor2) && ((col-oszlop2==1) || (col-oszlop2==-1))) || (((col==oszlop2) && ((row-sor2==1) || (row-sor2==-1)))))
					||
					(((row == sor3) && ((col-oszlop3==1) || (col-oszlop3==-1))) || (((col==oszlop3) && ((row-sor3==1) || (row-sor3==-1)))))))&&(__CLR4_3_1fafajvr3r80r.R.iget(680)!=0|true))||(__CLR4_3_1fafajvr3r80r.R.iget(681)==0&false)))
			{{
				__CLR4_3_1fafajvr3r80r.R.inc(682);board[row][col] = 1;
				__CLR4_3_1fafajvr3r80r.R.inc(683);szamlalo ++;
				__CLR4_3_1fafajvr3r80r.R.inc(684);draw.repaint();				
			}
			
			}__CLR4_3_1fafajvr3r80r.R.inc(685);if ((((fullBoard())&&(__CLR4_3_1fafajvr3r80r.R.iget(686)!=0|true))||(__CLR4_3_1fafajvr3r80r.R.iget(687)==0&false)))
			{{__CLR4_3_1fafajvr3r80r.R.inc(688);jatekvege();}
			
			}__CLR4_3_1fafajvr3r80r.R.inc(689);if ((((szamlalo > 3 && (!fullBoard()))&&(__CLR4_3_1fafajvr3r80r.R.iget(690)!=0|true))||(__CLR4_3_1fafajvr3r80r.R.iget(691)==0&false)))
				{{
					__CLR4_3_1fafajvr3r80r.R.inc(692);xTurn = (-1);
					__CLR4_3_1fafajvr3r80r.R.inc(693);message.setText("2. j\u00e1t\u00e9kos l\u00e9p - piros");
					__CLR4_3_1fafajvr3r80r.R.inc(694);szamlalo = 0; __CLR4_3_1fafajvr3r80r.R.inc(695);sor=0; __CLR4_3_1fafajvr3r80r.R.inc(696);sor2=0; __CLR4_3_1fafajvr3r80r.R.inc(697);sor3=0; __CLR4_3_1fafajvr3r80r.R.inc(698);oszlop=0; __CLR4_3_1fafajvr3r80r.R.inc(699);oszlop2=0; __CLR4_3_1fafajvr3r80r.R.inc(700);oszlop3=0;
				}
	}}finally{__CLR4_3_1fafajvr3r80r.R.flushNeeded();}}
	
	/**
	 * Az els\u0151 j\u00e1t\u00e9kos egy k\u00f6r\u00e9t kezeli.
	 * V\u00e9get \u00e9r, ha a maxim\u00e1lis 4 l\u00e9p\u00e9st el\u00e9ri vagy SPACE gombbal nem t\u00f6rt\u00e9nik v\u00e1lt\u00e1s.
	 * K\u00f6rben minden l\u00e9p\u00e9s ut\u00e1n vizsg\u00e1ljuk, hogy a t\u00e1bl\u00e1n van-e m\u00e9g kavics.
	 * Figyel\u00fcnk arra, hogy egy k\u00f6rben csak a mellette l\u00e9v\u0151 kavicsot lehet levenni.
	 * @param row A t\u00e1bla mez\u0151i.
	 * @param col A t\u00e1bla sorai.
	 */
	public void masodik (int row, int col) 
	{try{__CLR4_3_1fafajvr3r80r.R.inc(701);
		__CLR4_3_1fafajvr3r80r.R.inc(702);if (((((board[row][col] == 0) && (szamlalo == 0))&&(__CLR4_3_1fafajvr3r80r.R.iget(703)!=0|true))||(__CLR4_3_1fafajvr3r80r.R.iget(704)==0&false)))
		{{
			__CLR4_3_1fafajvr3r80r.R.inc(705);board[row][col] = 2;
			__CLR4_3_1fafajvr3r80r.R.inc(706);sor=row;
			__CLR4_3_1fafajvr3r80r.R.inc(707);oszlop=col;
			__CLR4_3_1fafajvr3r80r.R.inc(708);szamlalo ++;
			__CLR4_3_1fafajvr3r80r.R.inc(709);draw.repaint();
		}
		
		}__CLR4_3_1fafajvr3r80r.R.inc(710);if (((((board[row][col] == 0) && (szamlalo == 1) && ((((row == sor) && ((col-oszlop==1) || (col-oszlop==-1))) || (((col==oszlop) && ((row-sor==1) || (row-sor==-1)))))))&&(__CLR4_3_1fafajvr3r80r.R.iget(711)!=0|true))||(__CLR4_3_1fafajvr3r80r.R.iget(712)==0&false)))
		{{
			__CLR4_3_1fafajvr3r80r.R.inc(713);board[row][col] = 2;
			__CLR4_3_1fafajvr3r80r.R.inc(714);sor2=row;
			__CLR4_3_1fafajvr3r80r.R.inc(715);oszlop2=col;
			__CLR4_3_1fafajvr3r80r.R.inc(716);szamlalo ++;
			__CLR4_3_1fafajvr3r80r.R.inc(717);draw.repaint();
			
		}
		
		}__CLR4_3_1fafajvr3r80r.R.inc(718);if (((((board[row][col] == 0) && (szamlalo == 2) && 
				((((row == sor) && ((col-oszlop==1) || (col-oszlop==-1))) || (((col==oszlop) && ((row-sor==1) || (row-sor==-1))))) 
				||
				(((row == sor2) && ((col-oszlop2==1) || (col-oszlop2==-1))) || (((col==oszlop2) && ((row-sor2==1) || (row-sor2==-1)))))))&&(__CLR4_3_1fafajvr3r80r.R.iget(719)!=0|true))||(__CLR4_3_1fafajvr3r80r.R.iget(720)==0&false)))
		{{
			__CLR4_3_1fafajvr3r80r.R.inc(721);board[row][col] = 2;
			__CLR4_3_1fafajvr3r80r.R.inc(722);sor3=row;
			__CLR4_3_1fafajvr3r80r.R.inc(723);oszlop3=col;
			__CLR4_3_1fafajvr3r80r.R.inc(724);szamlalo ++;
			__CLR4_3_1fafajvr3r80r.R.inc(725);draw.repaint();
		}
		
		}__CLR4_3_1fafajvr3r80r.R.inc(726);if (((((board[row][col] == 0) && (szamlalo == 3) &&
				((((row == sor) && ((col-oszlop==1) || (col-oszlop==-1))) || (((col==oszlop) && ((row-sor==1) || (row-sor==-1))))) 
				|| 
				(((row == sor2) && ((col-oszlop2==1) || (col-oszlop2==-1))) || (((col==oszlop2) && ((row-sor2==1) || (row-sor2==-1)))))
				||
				(((row == sor3) && ((col-oszlop3==1) || (col-oszlop3==-1))) || (((col==oszlop3) && ((row-sor3==1) || (row-sor3==-1)))))))&&(__CLR4_3_1fafajvr3r80r.R.iget(727)!=0|true))||(__CLR4_3_1fafajvr3r80r.R.iget(728)==0&false)))
		{{
			__CLR4_3_1fafajvr3r80r.R.inc(729);board[row][col] = 2;
			__CLR4_3_1fafajvr3r80r.R.inc(730);szamlalo ++;
			__CLR4_3_1fafajvr3r80r.R.inc(731);draw.repaint();	
		}
		
		}__CLR4_3_1fafajvr3r80r.R.inc(732);if ((((fullBoard())&&(__CLR4_3_1fafajvr3r80r.R.iget(733)!=0|true))||(__CLR4_3_1fafajvr3r80r.R.iget(734)==0&false)))
			{{__CLR4_3_1fafajvr3r80r.R.inc(735);jatekvege();}
		
		}__CLR4_3_1fafajvr3r80r.R.inc(736);if ((((szamlalo > 3 && (!fullBoard()))&&(__CLR4_3_1fafajvr3r80r.R.iget(737)!=0|true))||(__CLR4_3_1fafajvr3r80r.R.iget(738)==0&false)))
			{{
				__CLR4_3_1fafajvr3r80r.R.inc(739);xTurn = (1);
				__CLR4_3_1fafajvr3r80r.R.inc(740);message.setText("1. j\u00e1t\u00e9kos l\u00e9p - z\u00f6ld");
				__CLR4_3_1fafajvr3r80r.R.inc(741);szamlalo = 0; __CLR4_3_1fafajvr3r80r.R.inc(742);sor=0; __CLR4_3_1fafajvr3r80r.R.inc(743);sor2=0; __CLR4_3_1fafajvr3r80r.R.inc(744);sor3=0; __CLR4_3_1fafajvr3r80r.R.inc(745);oszlop=0; __CLR4_3_1fafajvr3r80r.R.inc(746);oszlop2=0; __CLR4_3_1fafajvr3r80r.R.inc(747);oszlop3=0;
			}
	}}finally{__CLR4_3_1fafajvr3r80r.R.flushNeeded();}}

	/**
	 * Mez\u0151t elv\u00e1laszt\u00f3 vonalak kirajzol\u00e1s\u00e1ra szolg\u00e1l.
	 * Kattint\u00e1s megvizsg\u00e1l\u00e1sa ut\u00e1n a kavics k\u00e9p\u00e9nek megv\u00e1ltoztat\u00e1sa.
	 *
	 */
	class Drawing extends JComponent {
		public void paint(Graphics g) {try{__CLR4_3_1fafajvr3r80r.R.inc(748);
			__CLR4_3_1fafajvr3r80r.R.inc(749);Graphics2D g2 = (Graphics2D) g;
			__CLR4_3_1fafajvr3r80r.R.inc(750);for (int row = 0; (((row < 4)&&(__CLR4_3_1fafajvr3r80r.R.iget(751)!=0|true))||(__CLR4_3_1fafajvr3r80r.R.iget(752)==0&false)); row++)
				{__CLR4_3_1fafajvr3r80r.R.inc(753);for (int col = 0; (((col < 4)&&(__CLR4_3_1fafajvr3r80r.R.iget(754)!=0|true))||(__CLR4_3_1fafajvr3r80r.R.iget(755)==0&false)); col++) {{
					__CLR4_3_1fafajvr3r80r.R.inc(756);g.drawImage(boardPictures[board[row][col]].getImage(), col * 196, row * 132, 196, 132, this);
				}
			}}__CLR4_3_1fafajvr3r80r.R.inc(757);g2.setStroke(new BasicStroke(10));
			__CLR4_3_1fafajvr3r80r.R.inc(758);g.fillRect(196, 0, 5, 528);
			__CLR4_3_1fafajvr3r80r.R.inc(759);g.fillRect(392, 0, 5, 528);
			__CLR4_3_1fafajvr3r80r.R.inc(760);g.fillRect(588, 0, 5, 528);

			__CLR4_3_1fafajvr3r80r.R.inc(761);g.fillRect(0, 132, 784, 5);
			__CLR4_3_1fafajvr3r80r.R.inc(762);g.fillRect(0, 264, 784, 5);
			__CLR4_3_1fafajvr3r80r.R.inc(763);g.fillRect(0, 396, 784, 5);
	}finally{__CLR4_3_1fafajvr3r80r.R.flushNeeded();}}
	}
	
	/**
	 * Az eg\u00e9r kattint\u00e1s\u00e1nak \u00e9rz\u00e9kel\u00e9s\u00e9re szolg\u00e1l.
	 * A k\u00f6r \u00e1tad\u00e1sa a m\u00e1sik j\u00e1t\u00e9kosnak.
	 */
	public void mouseReleased(MouseEvent e) 
	{try{__CLR4_3_1fafajvr3r80r.R.inc(764);
		__CLR4_3_1fafajvr3r80r.R.inc(765);if ((((e.getButton() == MouseEvent.BUTTON1)&&(__CLR4_3_1fafajvr3r80r.R.iget(766)!=0|true))||(__CLR4_3_1fafajvr3r80r.R.iget(767)==0&false))) 
		{{
			/**
			 * A mez\u0151k sorainak \u00e9rz\u00e9kel\u00e9se.
			 */
			__CLR4_3_1fafajvr3r80r.R.inc(768);int row = e.getY() / 142;
			/**
			 * A mez\u0151k oszlopainak \u00e9rz\u00e9kel\u00e9se.
			 */
			__CLR4_3_1fafajvr3r80r.R.inc(769);int col = e.getX() / 206;
			__CLR4_3_1fafajvr3r80r.R.inc(770);if ((((xTurn == (1))&&(__CLR4_3_1fafajvr3r80r.R.iget(771)!=0|true))||(__CLR4_3_1fafajvr3r80r.R.iget(772)==0&false)))
			{__CLR4_3_1fafajvr3r80r.R.inc(773);elso(row, col);
			}__CLR4_3_1fafajvr3r80r.R.inc(774);if ((((xTurn == (-1))&&(__CLR4_3_1fafajvr3r80r.R.iget(775)!=0|true))||(__CLR4_3_1fafajvr3r80r.R.iget(776)==0&false)))
			{__CLR4_3_1fafajvr3r80r.R.inc(777);masodik(row, col);	
		}}		
	}}finally{__CLR4_3_1fafajvr3r80r.R.flushNeeded();}}
	
	/**
	 * SPACE, valamint az ESC billenty\u0171k kezel\u00e9se.
	 */
	public void keyPressed(KeyEvent e) {try{__CLR4_3_1fafajvr3r80r.R.inc(778);
		/**
		 * Lenyomott billenty\u0171 elt\u00e1rol\u00e1s\u00e1ra szolg\u00e1l.
		 */
		__CLR4_3_1fafajvr3r80r.R.inc(779);int keyCode = e.getKeyCode();
		__CLR4_3_1fafajvr3r80r.R.inc(780);if (((((keyCode == KeyEvent.VK_SPACE) && (szamlalo >= 1))&&(__CLR4_3_1fafajvr3r80r.R.iget(781)!=0|true))||(__CLR4_3_1fafajvr3r80r.R.iget(782)==0&false))) 
		{{
			__CLR4_3_1fafajvr3r80r.R.inc(783);xTurn *= (-1);
			__CLR4_3_1fafajvr3r80r.R.inc(784);szamlalo = 0; __CLR4_3_1fafajvr3r80r.R.inc(785);sor=0; __CLR4_3_1fafajvr3r80r.R.inc(786);sor2=0; __CLR4_3_1fafajvr3r80r.R.inc(787);sor3=0; __CLR4_3_1fafajvr3r80r.R.inc(788);oszlop=0; __CLR4_3_1fafajvr3r80r.R.inc(789);oszlop2=0; __CLR4_3_1fafajvr3r80r.R.inc(790);oszlop3=0;
			__CLR4_3_1fafajvr3r80r.R.inc(791);if ((((xTurn == (1))&&(__CLR4_3_1fafajvr3r80r.R.iget(792)!=0|true))||(__CLR4_3_1fafajvr3r80r.R.iget(793)==0&false)))
				{__CLR4_3_1fafajvr3r80r.R.inc(794);message.setText("1. j\u00e1t\u00e9kos l\u00e9p - z\u00f6ld");
			}__CLR4_3_1fafajvr3r80r.R.inc(795);if ((((xTurn == (-1))&&(__CLR4_3_1fafajvr3r80r.R.iget(796)!=0|true))||(__CLR4_3_1fafajvr3r80r.R.iget(797)==0&false)))
				{__CLR4_3_1fafajvr3r80r.R.inc(798);message.setText("2. j\u00e1t\u00e9kos l\u00e9p - piros");
		}}
		}__CLR4_3_1fafajvr3r80r.R.inc(799);if ((((keyCode == KeyEvent.VK_ESCAPE)&&(__CLR4_3_1fafajvr3r80r.R.iget(800)!=0|true))||(__CLR4_3_1fafajvr3r80r.R.iget(801)==0&false))) 
		{{
			__CLR4_3_1fafajvr3r80r.R.inc(802);datum();
			__CLR4_3_1fafajvr3r80r.R.inc(803);nyertes ="J\u00e1t\u00e9k f\u00e9lbeszak\u00edtva";
			__CLR4_3_1fafajvr3r80r.R.inc(804);uzenet ="J\u00e1t\u00e9k f\u00e9lbeszak\u00edtva.";
			__CLR4_3_1fafajvr3r80r.R.inc(805);fajlkezeles();
			__CLR4_3_1fafajvr3r80r.R.inc(806);JOptionPane.showMessageDialog(null, uzenet , "Eredm\u00e9ny", JOptionPane.INFORMATION_MESSAGE);
			__CLR4_3_1fafajvr3r80r.R.inc(807);jatek.dispose();
			__CLR4_3_1fafajvr3r80r.R.inc(808);new kezdokepernyo();
		}
		
	}}finally{__CLR4_3_1fafajvr3r80r.R.flushNeeded();}}
	
	/**
	 * @param e Eg\u00e9rmozg\u00e1s megfigyel\u00e9s\u00e9re szolg\u00e1l.
	 */
	public void keyReleased(KeyEvent e) {try{__CLR4_3_1fafajvr3r80r.R.inc(809);
    }finally{__CLR4_3_1fafajvr3r80r.R.flushNeeded();}}

	/**
	 * @param e Eg\u00e9rmozg\u00e1s megfigyel\u00e9s\u00e9re szolg\u00e1l.
	 */
	public void keyTyped(KeyEvent e) {try{__CLR4_3_1fafajvr3r80r.R.inc(810);
	}finally{__CLR4_3_1fafajvr3r80r.R.flushNeeded();}}  
	
	/**
	 * @param e Eg\u00e9rmozg\u00e1s megfigyel\u00e9s\u00e9re szolg\u00e1l.
	 */
	public void mouseClicked(MouseEvent e) {try{__CLR4_3_1fafajvr3r80r.R.inc(811);	
	}finally{__CLR4_3_1fafajvr3r80r.R.flushNeeded();}}

	/**
	 * @param e Eg\u00e9rmozg\u00e1s megfigyel\u00e9s\u00e9re szolg\u00e1l.
	 */
	public void mouseEntered(MouseEvent e) {try{__CLR4_3_1fafajvr3r80r.R.inc(812);		
	}finally{__CLR4_3_1fafajvr3r80r.R.flushNeeded();}}

	/**
	 * @param e Eg\u00e9rmozg\u00e1s megfigyel\u00e9s\u00e9re szolg\u00e1l.
	 */
	public void mouseExited(MouseEvent e) {try{__CLR4_3_1fafajvr3r80r.R.inc(813);
	}finally{__CLR4_3_1fafajvr3r80r.R.flushNeeded();}}

	/**
	 * @param e Eg\u00e9rmozg\u00e1s megfigyel\u00e9s\u00e9re szolg\u00e1l.
	 */
	public void mousePressed(MouseEvent e) {try{__CLR4_3_1fafajvr3r80r.R.inc(814);
	}finally{__CLR4_3_1fafajvr3r80r.R.flushNeeded();}}
}
