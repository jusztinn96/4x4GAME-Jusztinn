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
public class jatekablak implements KeyListener, MouseListener {public static class __CLR4_3_11dm1dmjvr4rmgu{public static com_atlassian_clover.CoverageRecorder R;public static com_atlassian_clover.CloverProfile[] profiles = { };@java.lang.SuppressWarnings("unchecked") public static <I, T extends I> I lambdaInc(final int i,final T l,final int si){java.lang.reflect.InvocationHandler h=new java.lang.reflect.InvocationHandler(){public java.lang.Object invoke(java.lang.Object p,java.lang.reflect.Method m,java.lang.Object[] a) throws Throwable{R.inc(i);R.inc(si);try{return m.invoke(l,a);}catch(java.lang.reflect.InvocationTargetException e){throw e.getCause()!=null?e.getCause():new RuntimeException("Clover failed to invoke instrumented lambda",e);}}};return (I)java.lang.reflect.Proxy.newProxyInstance(l.getClass().getClassLoader(),l.getClass().getInterfaces(),h);}static{com_atlassian_clover.CoverageRecorder _R=null;try{com_atlassian_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___4_3_1();if(20180921211537623L!=com_atlassian_clover.CloverVersionInfo.getBuildStamp()){com_atlassian_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_atlassian_clover.Clover.l("[CLOVER] WARNING: Instr=4.3.1#20180921211537623,Runtime="+com_atlassian_clover.CloverVersionInfo.getReleaseNum()+"#"+com_atlassian_clover.CloverVersionInfo.getBuildStamp());}R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getRecorder("\u0043\u003a\u005c\u005c\u0055\u0073\u0065\u0072\u0073\u005c\u005c\u006a\u0075\u0073\u007a\u0074\u005c\u005c\u0044\u0065\u0073\u006b\u0074\u006f\u0070\u005c\u005c\u0034\u0078\u0034\u0047\u0041\u004d\u0045\u002d\u004a\u0075\u0073\u007a\u0074\u0069\u006e\u006e\u005c\u005c\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1558039963445L,8589935092L,2052,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}public static final com_atlassian_clover.TestNameSniffer __CLR4_3_1_TEST_NAME_SNIFFER=com_atlassian_clover.TestNameSniffer.NULL_INSTANCE;
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
	 * Mez\u0151k t\u00e1rol\u00e1s\u00e1ra szolg\u00e1l.
	 */
	static int mezok;
	
	/**
	 * J\u00e1t\u00e9k v\u00e9get \u00e9r\u00e9s\u00e9nek tesztel\u00e9s\u00e9re.
	 */
	static boolean jatekveget = false;
	
	/**
	 * Ablak megjelen\u00edt\u00e9s\u00e9t szolg\u00e1lja.
	 *  
	 * @see kavicsos_jatek.kavics
	 */
	public jatekablak() 
	{try{__CLR4_3_11dm1dmjvr4rmgu.R.inc(1786);
		__CLR4_3_11dm1dmjvr4rmgu.R.inc(1787);for (int i = 0; (((i < boardPictures.length)&&(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1788)!=0|true))||(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1789)==0&false)); i++)
			{__CLR4_3_11dm1dmjvr4rmgu.R.inc(1790);boardPictures[i] = new ImageIcon(getClass().getClassLoader().getResource(i + ".jpg"));
		}__CLR4_3_11dm1dmjvr4rmgu.R.inc(1791);jatek.add(draw);
		__CLR4_3_11dm1dmjvr4rmgu.R.inc(1792);jatek.addKeyListener(this);
		__CLR4_3_11dm1dmjvr4rmgu.R.inc(1793);jatek.addMouseListener(this);
		__CLR4_3_11dm1dmjvr4rmgu.R.inc(1794);jatek.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		__CLR4_3_11dm1dmjvr4rmgu.R.inc(1795);jatek.setSize(800, 600);
		__CLR4_3_11dm1dmjvr4rmgu.R.inc(1796);jatek.setLocation(dim.width/2-jatek.getSize().width/2, dim.height/2-jatek.getSize().height/2);
		__CLR4_3_11dm1dmjvr4rmgu.R.inc(1797);message.setFont(new Font("Serif", Font.BOLD, 20));
		__CLR4_3_11dm1dmjvr4rmgu.R.inc(1798);message.setForeground(Color.blue);
		__CLR4_3_11dm1dmjvr4rmgu.R.inc(1799);message.setHorizontalAlignment(SwingConstants.CENTER);
		__CLR4_3_11dm1dmjvr4rmgu.R.inc(1800);jatek.add(message, "South");
		__CLR4_3_11dm1dmjvr4rmgu.R.inc(1801);jatek.setVisible(true);
	}finally{__CLR4_3_11dm1dmjvr4rmgu.R.flushNeeded();}}
	
	/**
	 * Napl\u00f3z\u00e1si met\u00f3dus.
	 */
	private static final Logger logger = LoggerFactory.getLogger(jatekablak.class);

	/**
	 * Ezen logikai v\u00e1ltoz\u00f3 seg\u00edts\u00e9g\u00e9vel vizsg\u00e1ljuk meg, hogy \u00fcres-e a t\u00e1bla, azaz nincs m\u00e1r rajta egy kavics sem.
	 *  
	 * @return A t\u00e1bla \u00fcres, azaz nincs rajta egy kavics sem.
	 */
	public boolean fullBoard() 
	{try{__CLR4_3_11dm1dmjvr4rmgu.R.inc(1802);
		/**
		* Ezen v\u00e1ltoz\u00f3 seg\u00edts\u00e9g\u00e9vel tartjuk sz\u00e1mon, hogy h\u00e1ny mez\u0151n nincs m\u00e1r kavics, azaz h\u00e1ny mez\u0151 \u00fcres.
		*/
		__CLR4_3_11dm1dmjvr4rmgu.R.inc(1803);int countBlank = 0;
		__CLR4_3_11dm1dmjvr4rmgu.R.inc(1804);for (int r = 0; (((r < 4)&&(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1805)!=0|true))||(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1806)==0&false)); r++) {{
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(1807);for (int col = 0; (((col < 4)&&(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1808)!=0|true))||(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1809)==0&false)); col++) {{
				__CLR4_3_11dm1dmjvr4rmgu.R.inc(1810);if ((((board[r][col] == 0)&&(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1811)!=0|true))||(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1812)==0&false)))
					{__CLR4_3_11dm1dmjvr4rmgu.R.inc(1813);countBlank++;
			}}
		}}
		}__CLR4_3_11dm1dmjvr4rmgu.R.inc(1814);return (countBlank == 0);
	}finally{__CLR4_3_11dm1dmjvr4rmgu.R.flushNeeded();}}
	
	/**
	 * Megsz\u00e1molja, hogy a t\u00e1bl\u00e1nk val\u00f3ban 4x4 mez\u0151b\u0151l \u00e1ll.
	 * @return Mez\u0151k darabsz\u00e1ma
	 */
	int mezok_ellenorzese() 
	{try{__CLR4_3_11dm1dmjvr4rmgu.R.inc(1815);
		/**
		* Ezen v\u00e1ltoz\u00f3 seg\u00edts\u00e9g\u00e9vel tartjuk sz\u00e1mon, hogy h\u00e1ny mez\u0151t sz\u00e1moltunk m\u00e1r meg.
		*/
		__CLR4_3_11dm1dmjvr4rmgu.R.inc(1816);mezok = 0;
		__CLR4_3_11dm1dmjvr4rmgu.R.inc(1817);for (int r = 0; (((r < 4)&&(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1818)!=0|true))||(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1819)==0&false)); r++) {{
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(1820);for (int col = 0; (((col < 4)&&(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1821)!=0|true))||(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1822)==0&false)); col++) {{
				__CLR4_3_11dm1dmjvr4rmgu.R.inc(1823);if ((((board[r][col] == 1)&&(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1824)!=0|true))||(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1825)==0&false)))
					{__CLR4_3_11dm1dmjvr4rmgu.R.inc(1826);mezok++;
			}}
		}}
		}__CLR4_3_11dm1dmjvr4rmgu.R.inc(1827);return (mezok);
	}finally{__CLR4_3_11dm1dmjvr4rmgu.R.flushNeeded();}}
	
	/**
	 * Az XML f\u00e1jlkezel\u00e9sre szolg\u00e1l.
	 * Ha az XML f\u00e1jl nem l\u00e9tezik, akkor l\u00e9trehoz egyet \u00e9s bele\u00edrja a legut\u00f3bbi eredm\u00e9nyt.
	 * Ha l\u00e9tezik az XML f\u00e1jl, akkor hozz\u00e1f\u0171zi a legut\u00f3bbi eredm\u00e9nyt a f\u00e1jlhoz.
	 */
	public void fajlkezeles() {try{__CLR4_3_11dm1dmjvr4rmgu.R.inc(1828);
		__CLR4_3_11dm1dmjvr4rmgu.R.inc(1829);fjl = new File(getClass().getClassLoader().getResource("ered.xml").getFile());
		__CLR4_3_11dm1dmjvr4rmgu.R.inc(1830);fajl = fjl.exists();
		__CLR4_3_11dm1dmjvr4rmgu.R.inc(1831);if ((((!fajl)&&(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1832)!=0|true))||(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1833)==0&false)))
		{{
        __CLR4_3_11dm1dmjvr4rmgu.R.inc(1834);DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
        __CLR4_3_11dm1dmjvr4rmgu.R.inc(1835);DocumentBuilder icBuilder;
        __CLR4_3_11dm1dmjvr4rmgu.R.inc(1836);try {
            __CLR4_3_11dm1dmjvr4rmgu.R.inc(1837);icBuilder = icFactory.newDocumentBuilder();
            __CLR4_3_11dm1dmjvr4rmgu.R.inc(1838);Document doc = icBuilder.newDocument();
            __CLR4_3_11dm1dmjvr4rmgu.R.inc(1839);Element mainRootElement = doc.createElement("M\u00e9rk\u0151z\u00e9sek");
            __CLR4_3_11dm1dmjvr4rmgu.R.inc(1840);doc.appendChild(mainRootElement);
 
            __CLR4_3_11dm1dmjvr4rmgu.R.inc(1841);mainRootElement.appendChild(jatszmak(doc, nyertes, pontosdatum));
 
            __CLR4_3_11dm1dmjvr4rmgu.R.inc(1842);Transformer transformer = TransformerFactory.newInstance().newTransformer();
            __CLR4_3_11dm1dmjvr4rmgu.R.inc(1843);DOMSource source = new DOMSource(doc);
            __CLR4_3_11dm1dmjvr4rmgu.R.inc(1844);StreamResult result = new StreamResult(new File(getClass().getClassLoader().getResource("ered.xml").getFile()));
            __CLR4_3_11dm1dmjvr4rmgu.R.inc(1845);transformer.transform(source, result);
 
            __CLR4_3_11dm1dmjvr4rmgu.R.inc(1846);logger.info("XML f\u00e1jl l\u00e9trehozva.");
 
        	} 	
        	catch (Exception e) {
            __CLR4_3_11dm1dmjvr4rmgu.R.inc(1847);e.printStackTrace();
        	}
		}
		}else
		{{
			
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(1848);try {
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(1849);DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(1850);DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(1851);Document doc = docBuilder.parse(fjl);
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(1852);Element root = doc.getDocumentElement();

            __CLR4_3_11dm1dmjvr4rmgu.R.inc(1853);root.appendChild(jatszmak(doc, nyertes, pontosdatum));

            __CLR4_3_11dm1dmjvr4rmgu.R.inc(1854);TransformerFactory transformerFactory = TransformerFactory.newInstance();
            __CLR4_3_11dm1dmjvr4rmgu.R.inc(1855);Transformer transformer = transformerFactory.newTransformer();
            __CLR4_3_11dm1dmjvr4rmgu.R.inc(1856);DOMSource source = new DOMSource(doc);
            __CLR4_3_11dm1dmjvr4rmgu.R.inc(1857);StreamResult result = new StreamResult(new File(getClass().getClassLoader().getResource("ered.xml").getFile()));
            __CLR4_3_11dm1dmjvr4rmgu.R.inc(1858);transformer.transform(source, result);
            
            __CLR4_3_11dm1dmjvr4rmgu.R.inc(1859);logger.info("XML f\u00e1jl sikeresen m\u00f3dos\u00edtva.");
            
			}
			catch (Exception e) {
	        __CLR4_3_11dm1dmjvr4rmgu.R.inc(1860);e.printStackTrace();
	        }
		}
    }}finally{__CLR4_3_11dm1dmjvr4rmgu.R.flushNeeded();}}
 
	/**
	 * 
	 * @param doc Az XML dokumentum.
	 * @param name Nyertes elt\u00e1rol\u00e1s\u00e1ra szolg\u00e1l.
	 * @param date A j\u00e1t\u00e9k befejez\u00e9s\u00e9nek pontos ideje.
	 * @return J\u00e1tszma tag \u00e9s a benne l\u00e9v\u0151 nyertes neve \u00e9s a j\u00e1tszma ideje.
	 */
    private static Node jatszmak(Document doc, String name, String date) {try{__CLR4_3_11dm1dmjvr4rmgu.R.inc(1861);
        __CLR4_3_11dm1dmjvr4rmgu.R.inc(1862);Element jatszma = doc.createElement("J\u00e1tszma");
        __CLR4_3_11dm1dmjvr4rmgu.R.inc(1863);jatszma.appendChild(jatszmaelem(doc, jatszma, "Nyertes", name));
        __CLR4_3_11dm1dmjvr4rmgu.R.inc(1864);jatszma.appendChild(jatszmaelem(doc, jatszma, "D\u00e1tum", date));
        __CLR4_3_11dm1dmjvr4rmgu.R.inc(1865);return jatszma;
    }finally{__CLR4_3_11dm1dmjvr4rmgu.R.flushNeeded();}}
    
    /**
     * 
     * @param doc Az XML dokumentum.
     * @param element Az XML dokumentum adott eleme.
     * @param name Elemn\u00e9v.
     * @param value \u00c9rt\u00e9k hozz\u00e1ad\u00e1sa az adott elemhez.
     * @return J\u00e1tszam elemei.
     */
 
    private static Node jatszmaelem(Document doc, Element element, String name, String value) {try{__CLR4_3_11dm1dmjvr4rmgu.R.inc(1866);
        __CLR4_3_11dm1dmjvr4rmgu.R.inc(1867);Element node = doc.createElement(name);
        __CLR4_3_11dm1dmjvr4rmgu.R.inc(1868);node.appendChild(doc.createTextNode(value));
        __CLR4_3_11dm1dmjvr4rmgu.R.inc(1869);return node;
    }finally{__CLR4_3_11dm1dmjvr4rmgu.R.flushNeeded();}}
    
    /**
     * A m\u00e9rk\u0151z\u00e9s befejez\u00e9s\u00e9nek ideje.
     */
    public void datum()
    {try{__CLR4_3_11dm1dmjvr4rmgu.R.inc(1870);
		__CLR4_3_11dm1dmjvr4rmgu.R.inc(1871);Date dNow = new Date( );
		__CLR4_3_11dm1dmjvr4rmgu.R.inc(1872);SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd. HH:mm:ss");
		__CLR4_3_11dm1dmjvr4rmgu.R.inc(1873);pontosdatum = ft.format(dNow);
    }finally{__CLR4_3_11dm1dmjvr4rmgu.R.flushNeeded();}}
    
    /**
     * A j\u00e1t\u00e9k v\u00e9ge t\u00e9r\u00e9se ut\u00e1ni feladatok elv\u00e9gz\u00e9s\u00e9re szolg\u00e1l.
     * Megadja a nyertes nev\u00e9t, a befejez\u00e9s d\u00e1tum\u00e1t.
     * Elind\u00edtja a f\u00e1jlkezel\u00e9st.
     * Felugr\u00f3 ablakban k\u00f6zli a j\u00e1t\u00e9k v\u00e9g\u00e9t.
     * Bez\u00e1rja a j\u00e1t\u00e9kteret \u00e9s visszair\u00e1ny\u00edt a kezd\u0151k\u00e9perny\u0151re.
     */
	
	public void jatekvege()
	{try{__CLR4_3_11dm1dmjvr4rmgu.R.inc(1874);
		__CLR4_3_11dm1dmjvr4rmgu.R.inc(1875);datum();
		__CLR4_3_11dm1dmjvr4rmgu.R.inc(1876);if ((((xTurn == (1))&&(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1877)!=0|true))||(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1878)==0&false))) {{__CLR4_3_11dm1dmjvr4rmgu.R.inc(1879);uzenet = "2. j\u00e1t\u00e9kos (piros) nyert! Eredm\u00e9nyek elmentve."; __CLR4_3_11dm1dmjvr4rmgu.R.inc(1880);nyertes ="2. j\u00e1t\u00e9kos (piros)";}
		}__CLR4_3_11dm1dmjvr4rmgu.R.inc(1881);if ((((xTurn == (-1))&&(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1882)!=0|true))||(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1883)==0&false))) {{__CLR4_3_11dm1dmjvr4rmgu.R.inc(1884);uzenet = "1. j\u00e1t\u00e9kos (z\u00f6ld) nyert! Eredm\u00e9nyek elmentve."; __CLR4_3_11dm1dmjvr4rmgu.R.inc(1885);nyertes ="1. j\u00e1t\u00e9kos (z\u00f6ld)";}
		}__CLR4_3_11dm1dmjvr4rmgu.R.inc(1886);fajlkezeles();
		__CLR4_3_11dm1dmjvr4rmgu.R.inc(1887);JOptionPane.showMessageDialog(null, uzenet , "Eredm\u00e9ny", JOptionPane.INFORMATION_MESSAGE);
		__CLR4_3_11dm1dmjvr4rmgu.R.inc(1888);jatek.dispose();
		__CLR4_3_11dm1dmjvr4rmgu.R.inc(1889);new kezdokepernyo();
		__CLR4_3_11dm1dmjvr4rmgu.R.inc(1890);jatekveget = true;
	}finally{__CLR4_3_11dm1dmjvr4rmgu.R.flushNeeded();}}
	
	/**
	 * Az els\u0151 j\u00e1t\u00e9kos egy k\u00f6r\u00e9t kezeli.
	 * V\u00e9get \u00e9r, ha a maxim\u00e1lis 4 l\u00e9p\u00e9st el\u00e9ri vagy SPACE gombbal nem t\u00f6rt\u00e9nik v\u00e1lt\u00e1s.
	 * K\u00f6rben minden l\u00e9p\u00e9s ut\u00e1n vizsg\u00e1ljuk, hogy a t\u00e1bl\u00e1n van-e m\u00e9g kavics.
	 * Figyel\u00fcnk arra, hogy egy k\u00f6rben csak a mellette l\u00e9v\u0151 kavicsot lehet levenni.
	 * @param row A t\u00e1bla mez\u0151i.
	 * @param col A t\u00e1bla sorai.
	 */
	public void elso (int row, int col) {try{__CLR4_3_11dm1dmjvr4rmgu.R.inc(1891);
		
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(1892);if (((((board[row][col] == 0) && (szamlalo == 0))&&(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1893)!=0|true))||(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1894)==0&false)))
			{{
				__CLR4_3_11dm1dmjvr4rmgu.R.inc(1895);board[row][col] = 1;
				__CLR4_3_11dm1dmjvr4rmgu.R.inc(1896);sor=row;
				__CLR4_3_11dm1dmjvr4rmgu.R.inc(1897);oszlop=col;
				__CLR4_3_11dm1dmjvr4rmgu.R.inc(1898);szamlalo ++;
				__CLR4_3_11dm1dmjvr4rmgu.R.inc(1899);draw.repaint();
			}
			
			}__CLR4_3_11dm1dmjvr4rmgu.R.inc(1900);if (((((board[row][col] == 0) && (szamlalo == 1) && ((((row == sor) && ((col-oszlop==1) || (col-oszlop==-1))) || (((col==oszlop) && ((row-sor==1) || (row-sor==-1)))))))&&(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1901)!=0|true))||(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1902)==0&false)))
			{{
				__CLR4_3_11dm1dmjvr4rmgu.R.inc(1903);board[row][col] = 1;
				__CLR4_3_11dm1dmjvr4rmgu.R.inc(1904);sor2=row;
				__CLR4_3_11dm1dmjvr4rmgu.R.inc(1905);oszlop2=col;
				__CLR4_3_11dm1dmjvr4rmgu.R.inc(1906);szamlalo ++;
				__CLR4_3_11dm1dmjvr4rmgu.R.inc(1907);draw.repaint();
				
			}
			
			}__CLR4_3_11dm1dmjvr4rmgu.R.inc(1908);if (((((board[row][col] == 0) && (szamlalo == 2) && 
					((((row == sor) && ((col-oszlop==1) || (col-oszlop==-1))) || (((col==oszlop) && ((row-sor==1) || (row-sor==-1))))) 
					||
					(((row == sor2) && ((col-oszlop2==1) || (col-oszlop2==-1))) || (((col==oszlop2) && ((row-sor2==1) || (row-sor2==-1)))))))&&(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1909)!=0|true))||(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1910)==0&false)))
			{{
				__CLR4_3_11dm1dmjvr4rmgu.R.inc(1911);board[row][col] = 1;
				__CLR4_3_11dm1dmjvr4rmgu.R.inc(1912);sor3=row;
				__CLR4_3_11dm1dmjvr4rmgu.R.inc(1913);oszlop3=col;
				__CLR4_3_11dm1dmjvr4rmgu.R.inc(1914);szamlalo ++;
				__CLR4_3_11dm1dmjvr4rmgu.R.inc(1915);draw.repaint();
			}
			
			}__CLR4_3_11dm1dmjvr4rmgu.R.inc(1916);if (((((board[row][col] == 0) && (szamlalo == 3) &&
					((((row == sor) && ((col-oszlop==1) || (col-oszlop==-1))) || (((col==oszlop) && ((row-sor==1) || (row-sor==-1))))) 
					|| 
					(((row == sor2) && ((col-oszlop2==1) || (col-oszlop2==-1))) || (((col==oszlop2) && ((row-sor2==1) || (row-sor2==-1)))))
					||
					(((row == sor3) && ((col-oszlop3==1) || (col-oszlop3==-1))) || (((col==oszlop3) && ((row-sor3==1) || (row-sor3==-1)))))))&&(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1917)!=0|true))||(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1918)==0&false)))
			{{
				__CLR4_3_11dm1dmjvr4rmgu.R.inc(1919);board[row][col] = 1;
				__CLR4_3_11dm1dmjvr4rmgu.R.inc(1920);szamlalo ++;
				__CLR4_3_11dm1dmjvr4rmgu.R.inc(1921);draw.repaint();				
			}
			
			}__CLR4_3_11dm1dmjvr4rmgu.R.inc(1922);if ((((fullBoard())&&(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1923)!=0|true))||(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1924)==0&false)))
			{{__CLR4_3_11dm1dmjvr4rmgu.R.inc(1925);jatekvege();}
			
			}__CLR4_3_11dm1dmjvr4rmgu.R.inc(1926);if ((((szamlalo > 3 && (!fullBoard()))&&(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1927)!=0|true))||(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1928)==0&false)))
				{{
					__CLR4_3_11dm1dmjvr4rmgu.R.inc(1929);xTurn = (-1);
					__CLR4_3_11dm1dmjvr4rmgu.R.inc(1930);message.setText("2. j\u00e1t\u00e9kos l\u00e9p - piros");
					__CLR4_3_11dm1dmjvr4rmgu.R.inc(1931);szamlalo = 0; __CLR4_3_11dm1dmjvr4rmgu.R.inc(1932);sor=0; __CLR4_3_11dm1dmjvr4rmgu.R.inc(1933);sor2=0; __CLR4_3_11dm1dmjvr4rmgu.R.inc(1934);sor3=0; __CLR4_3_11dm1dmjvr4rmgu.R.inc(1935);oszlop=0; __CLR4_3_11dm1dmjvr4rmgu.R.inc(1936);oszlop2=0; __CLR4_3_11dm1dmjvr4rmgu.R.inc(1937);oszlop3=0;
				}
	}}finally{__CLR4_3_11dm1dmjvr4rmgu.R.flushNeeded();}}
	
	/**
	 * Az els\u0151 j\u00e1t\u00e9kos egy k\u00f6r\u00e9t kezeli.
	 * V\u00e9get \u00e9r, ha a maxim\u00e1lis 4 l\u00e9p\u00e9st el\u00e9ri vagy SPACE gombbal nem t\u00f6rt\u00e9nik v\u00e1lt\u00e1s.
	 * K\u00f6rben minden l\u00e9p\u00e9s ut\u00e1n vizsg\u00e1ljuk, hogy a t\u00e1bl\u00e1n van-e m\u00e9g kavics.
	 * Figyel\u00fcnk arra, hogy egy k\u00f6rben csak a mellette l\u00e9v\u0151 kavicsot lehet levenni.
	 * @param row A t\u00e1bla mez\u0151i.
	 * @param col A t\u00e1bla sorai.
	 */
	public void masodik (int row, int col) 
	{try{__CLR4_3_11dm1dmjvr4rmgu.R.inc(1938);
		__CLR4_3_11dm1dmjvr4rmgu.R.inc(1939);if (((((board[row][col] == 0) && (szamlalo == 0))&&(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1940)!=0|true))||(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1941)==0&false)))
		{{
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(1942);board[row][col] = 2;
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(1943);sor=row;
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(1944);oszlop=col;
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(1945);szamlalo ++;
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(1946);draw.repaint();
		}
		
		}__CLR4_3_11dm1dmjvr4rmgu.R.inc(1947);if (((((board[row][col] == 0) && (szamlalo == 1) && ((((row == sor) && ((col-oszlop==1) || (col-oszlop==-1))) || (((col==oszlop) && ((row-sor==1) || (row-sor==-1)))))))&&(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1948)!=0|true))||(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1949)==0&false)))
		{{
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(1950);board[row][col] = 2;
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(1951);sor2=row;
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(1952);oszlop2=col;
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(1953);szamlalo ++;
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(1954);draw.repaint();
			
		}
		
		}__CLR4_3_11dm1dmjvr4rmgu.R.inc(1955);if (((((board[row][col] == 0) && (szamlalo == 2) && 
				((((row == sor) && ((col-oszlop==1) || (col-oszlop==-1))) || (((col==oszlop) && ((row-sor==1) || (row-sor==-1))))) 
				||
				(((row == sor2) && ((col-oszlop2==1) || (col-oszlop2==-1))) || (((col==oszlop2) && ((row-sor2==1) || (row-sor2==-1)))))))&&(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1956)!=0|true))||(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1957)==0&false)))
		{{
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(1958);board[row][col] = 2;
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(1959);sor3=row;
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(1960);oszlop3=col;
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(1961);szamlalo ++;
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(1962);draw.repaint();
		}
		
		}__CLR4_3_11dm1dmjvr4rmgu.R.inc(1963);if (((((board[row][col] == 0) && (szamlalo == 3) &&
				((((row == sor) && ((col-oszlop==1) || (col-oszlop==-1))) || (((col==oszlop) && ((row-sor==1) || (row-sor==-1))))) 
				|| 
				(((row == sor2) && ((col-oszlop2==1) || (col-oszlop2==-1))) || (((col==oszlop2) && ((row-sor2==1) || (row-sor2==-1)))))
				||
				(((row == sor3) && ((col-oszlop3==1) || (col-oszlop3==-1))) || (((col==oszlop3) && ((row-sor3==1) || (row-sor3==-1)))))))&&(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1964)!=0|true))||(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1965)==0&false)))
		{{
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(1966);board[row][col] = 2;
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(1967);szamlalo ++;
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(1968);draw.repaint();	
		}
		
		}__CLR4_3_11dm1dmjvr4rmgu.R.inc(1969);if ((((fullBoard())&&(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1970)!=0|true))||(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1971)==0&false)))
			{{__CLR4_3_11dm1dmjvr4rmgu.R.inc(1972);jatekvege();}
		
		}__CLR4_3_11dm1dmjvr4rmgu.R.inc(1973);if ((((szamlalo > 3 && (!fullBoard()))&&(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1974)!=0|true))||(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1975)==0&false)))
			{{
				__CLR4_3_11dm1dmjvr4rmgu.R.inc(1976);xTurn = (1);
				__CLR4_3_11dm1dmjvr4rmgu.R.inc(1977);message.setText("1. j\u00e1t\u00e9kos l\u00e9p - z\u00f6ld");
				__CLR4_3_11dm1dmjvr4rmgu.R.inc(1978);szamlalo = 0; __CLR4_3_11dm1dmjvr4rmgu.R.inc(1979);sor=0; __CLR4_3_11dm1dmjvr4rmgu.R.inc(1980);sor2=0; __CLR4_3_11dm1dmjvr4rmgu.R.inc(1981);sor3=0; __CLR4_3_11dm1dmjvr4rmgu.R.inc(1982);oszlop=0; __CLR4_3_11dm1dmjvr4rmgu.R.inc(1983);oszlop2=0; __CLR4_3_11dm1dmjvr4rmgu.R.inc(1984);oszlop3=0;
			}
	}}finally{__CLR4_3_11dm1dmjvr4rmgu.R.flushNeeded();}}

	/**
	 * Kattint\u00e1s megvizsg\u00e1l\u00e1sa ut\u00e1n a kavics k\u00e9p\u00e9nek megv\u00e1ltoztat\u00e1sa.
	 */
	class Drawing extends JComponent {
		/**
		 * @param g Mez\u0151t elv\u00e1laszt\u00f3 vonalak kirajzol\u00e1s\u00e1ra szolg\u00e1l.
		 */
		public void paint(Graphics g) {try{__CLR4_3_11dm1dmjvr4rmgu.R.inc(1985);
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(1986);Graphics2D g2 = (Graphics2D) g;
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(1987);for (int row = 0; (((row < 4)&&(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1988)!=0|true))||(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1989)==0&false)); row++)
				{__CLR4_3_11dm1dmjvr4rmgu.R.inc(1990);for (int col = 0; (((col < 4)&&(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1991)!=0|true))||(__CLR4_3_11dm1dmjvr4rmgu.R.iget(1992)==0&false)); col++) {{
					__CLR4_3_11dm1dmjvr4rmgu.R.inc(1993);g.drawImage(boardPictures[board[row][col]].getImage(), col * 196, row * 132, 196, 132, this);
				}
			}}__CLR4_3_11dm1dmjvr4rmgu.R.inc(1994);g2.setStroke(new BasicStroke(10));
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(1995);g.fillRect(196, 0, 5, 528);
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(1996);g.fillRect(392, 0, 5, 528);
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(1997);g.fillRect(588, 0, 5, 528);

			__CLR4_3_11dm1dmjvr4rmgu.R.inc(1998);g.fillRect(0, 132, 784, 5);
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(1999);g.fillRect(0, 264, 784, 5);
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(2000);g.fillRect(0, 396, 784, 5);
	}finally{__CLR4_3_11dm1dmjvr4rmgu.R.flushNeeded();}}
	}
	
	/**
	 * @param e Az eg\u00e9r kattint\u00e1s\u00e1nak \u00e9rz\u00e9kel\u00e9s\u00e9re szolg\u00e1l.
	 * A k\u00f6r \u00e1tad\u00e1sa a m\u00e1sik j\u00e1t\u00e9kosnak.
	 */
	public void mouseReleased(MouseEvent e) 
	{try{__CLR4_3_11dm1dmjvr4rmgu.R.inc(2001);
		__CLR4_3_11dm1dmjvr4rmgu.R.inc(2002);if ((((e.getButton() == MouseEvent.BUTTON1)&&(__CLR4_3_11dm1dmjvr4rmgu.R.iget(2003)!=0|true))||(__CLR4_3_11dm1dmjvr4rmgu.R.iget(2004)==0&false))) 
		{{
			/**
			 * A mez\u0151k sorainak \u00e9rz\u00e9kel\u00e9se.
			 */
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(2005);int row = e.getY() / 142;
			/**
			 * A mez\u0151k oszlopainak \u00e9rz\u00e9kel\u00e9se.
			 */
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(2006);int col = e.getX() / 206;
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(2007);if ((((xTurn == (1))&&(__CLR4_3_11dm1dmjvr4rmgu.R.iget(2008)!=0|true))||(__CLR4_3_11dm1dmjvr4rmgu.R.iget(2009)==0&false)))
			{__CLR4_3_11dm1dmjvr4rmgu.R.inc(2010);elso(row, col);
			}__CLR4_3_11dm1dmjvr4rmgu.R.inc(2011);if ((((xTurn == (-1))&&(__CLR4_3_11dm1dmjvr4rmgu.R.iget(2012)!=0|true))||(__CLR4_3_11dm1dmjvr4rmgu.R.iget(2013)==0&false)))
			{__CLR4_3_11dm1dmjvr4rmgu.R.inc(2014);masodik(row, col);	
		}}		
	}}finally{__CLR4_3_11dm1dmjvr4rmgu.R.flushNeeded();}}
	
	/**
	 * @param e SPACE, valamint az ESC billenty\u0171k kezel\u00e9se.
	 */
	public void keyPressed(KeyEvent e) {try{__CLR4_3_11dm1dmjvr4rmgu.R.inc(2015);
		/**
		 * Lenyomott billenty\u0171 elt\u00e1rol\u00e1s\u00e1ra szolg\u00e1l.
		 */
		__CLR4_3_11dm1dmjvr4rmgu.R.inc(2016);int keyCode = e.getKeyCode();
		__CLR4_3_11dm1dmjvr4rmgu.R.inc(2017);if (((((keyCode == KeyEvent.VK_SPACE) && (szamlalo >= 1))&&(__CLR4_3_11dm1dmjvr4rmgu.R.iget(2018)!=0|true))||(__CLR4_3_11dm1dmjvr4rmgu.R.iget(2019)==0&false))) 
		{{
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(2020);xTurn *= (-1);
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(2021);szamlalo = 0; __CLR4_3_11dm1dmjvr4rmgu.R.inc(2022);sor=0; __CLR4_3_11dm1dmjvr4rmgu.R.inc(2023);sor2=0; __CLR4_3_11dm1dmjvr4rmgu.R.inc(2024);sor3=0; __CLR4_3_11dm1dmjvr4rmgu.R.inc(2025);oszlop=0; __CLR4_3_11dm1dmjvr4rmgu.R.inc(2026);oszlop2=0; __CLR4_3_11dm1dmjvr4rmgu.R.inc(2027);oszlop3=0;
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(2028);if ((((xTurn == (1))&&(__CLR4_3_11dm1dmjvr4rmgu.R.iget(2029)!=0|true))||(__CLR4_3_11dm1dmjvr4rmgu.R.iget(2030)==0&false)))
				{__CLR4_3_11dm1dmjvr4rmgu.R.inc(2031);message.setText("1. j\u00e1t\u00e9kos l\u00e9p - z\u00f6ld");
			}__CLR4_3_11dm1dmjvr4rmgu.R.inc(2032);if ((((xTurn == (-1))&&(__CLR4_3_11dm1dmjvr4rmgu.R.iget(2033)!=0|true))||(__CLR4_3_11dm1dmjvr4rmgu.R.iget(2034)==0&false)))
				{__CLR4_3_11dm1dmjvr4rmgu.R.inc(2035);message.setText("2. j\u00e1t\u00e9kos l\u00e9p - piros");
		}}
		}__CLR4_3_11dm1dmjvr4rmgu.R.inc(2036);if ((((keyCode == KeyEvent.VK_ESCAPE)&&(__CLR4_3_11dm1dmjvr4rmgu.R.iget(2037)!=0|true))||(__CLR4_3_11dm1dmjvr4rmgu.R.iget(2038)==0&false))) 
		{{
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(2039);datum();
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(2040);nyertes ="J\u00e1t\u00e9k f\u00e9lbeszak\u00edtva";
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(2041);uzenet ="J\u00e1t\u00e9k f\u00e9lbeszak\u00edtva.";
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(2042);fajlkezeles();
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(2043);JOptionPane.showMessageDialog(null, uzenet , "Eredm\u00e9ny", JOptionPane.INFORMATION_MESSAGE);
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(2044);jatek.dispose();
			__CLR4_3_11dm1dmjvr4rmgu.R.inc(2045);new kezdokepernyo();
		}
		
	}}finally{__CLR4_3_11dm1dmjvr4rmgu.R.flushNeeded();}}
	
	/**
	 * @param e Eg\u00e9rmozg\u00e1s megfigyel\u00e9s\u00e9re szolg\u00e1l.
	 */
	public void keyReleased(KeyEvent e) {try{__CLR4_3_11dm1dmjvr4rmgu.R.inc(2046);
    }finally{__CLR4_3_11dm1dmjvr4rmgu.R.flushNeeded();}}

	/**
	 * @param e Eg\u00e9rmozg\u00e1s megfigyel\u00e9s\u00e9re szolg\u00e1l.
	 */
	public void keyTyped(KeyEvent e) {try{__CLR4_3_11dm1dmjvr4rmgu.R.inc(2047);
	}finally{__CLR4_3_11dm1dmjvr4rmgu.R.flushNeeded();}}  
	
	/**
	 * @param e Eg\u00e9rmozg\u00e1s megfigyel\u00e9s\u00e9re szolg\u00e1l.
	 */
	public void mouseClicked(MouseEvent e) {try{__CLR4_3_11dm1dmjvr4rmgu.R.inc(2048);	
	}finally{__CLR4_3_11dm1dmjvr4rmgu.R.flushNeeded();}}

	/**
	 * @param e Eg\u00e9rmozg\u00e1s megfigyel\u00e9s\u00e9re szolg\u00e1l.
	 */
	public void mouseEntered(MouseEvent e) {try{__CLR4_3_11dm1dmjvr4rmgu.R.inc(2049);		
	}finally{__CLR4_3_11dm1dmjvr4rmgu.R.flushNeeded();}}

	/**
	 * @param e Eg\u00e9rmozg\u00e1s megfigyel\u00e9s\u00e9re szolg\u00e1l.
	 */
	public void mouseExited(MouseEvent e) {try{__CLR4_3_11dm1dmjvr4rmgu.R.inc(2050);
	}finally{__CLR4_3_11dm1dmjvr4rmgu.R.flushNeeded();}}

	/**
	 * @param e Eg\u00e9rmozg\u00e1s megfigyel\u00e9s\u00e9re szolg\u00e1l.
	 */
	public void mousePressed(MouseEvent e) {try{__CLR4_3_11dm1dmjvr4rmgu.R.inc(2051);
	}finally{__CLR4_3_11dm1dmjvr4rmgu.R.flushNeeded();}}
}
