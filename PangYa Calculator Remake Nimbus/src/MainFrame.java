
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.event.KeyEvent;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainFrame.java
 *
 * Created on Nov 30, 2010, 10:32:28 PM
 */

/**
 *
 * @author Kurisutaru
 */

public class MainFrame extends javax.swing.JFrame {
    private int i =0;
    private Timer timer;
    private int flag = 0;

    void Hk()
    {
        
        try {
    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            break;
        }
    }
    } catch (Exception e) {
    // If Nimbus is not available, you can set the GUI to another look and feel.
}
    }
    
    void HWICalc()
    {
        Double Degree = Double.parseDouble(DegreeTextField.getText());
        Double Windspeed = Double.parseDouble(WindspeedTextField.getText());
        Double HWI = Double.parseDouble(HWITextField.getText());
        Double Pin = ((((Math.sin(Math.toRadians(Degree))))*Windspeed)*HWI);
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        PbTextField.setText(twoDForm.format(Pin));
    }
    
    void PowerCalc()
    {
        Double Power;
        Double PowerHWI;
        Double WindSpeedPower;
        Double WindDegreePower;
        Double Elevation;
        Integer TerrainEffect =0;
        Double Result;
        Double Yard;
        
        Power = Double.parseDouble(PowerTextField.getText());
        PowerHWI = Double.parseDouble(PowerHWITextField.getText());
        WindSpeedPower = Double.parseDouble(WindSpeedPowerTextField.getText());
        if(WindDegreePowerTextField.getText().startsWith("-") == true)
        {
            WindDegreePower = Double.parseDouble(WindDegreePowerTextField.getText().substring(1))*-1;
        }
        else
        {
            WindDegreePower = Double.parseDouble(WindDegreePowerTextField.getText());
        }
        if(ElevationTextField.getText().startsWith("-") == true)
        {
            Elevation = Double.parseDouble(ElevationTextField.getText().substring(1))*-1;
        }
        else
        {
            Elevation = Double.parseDouble(ElevationTextField.getText());
        }
        
        if(TerrainEffectComboBox.getSelectedIndex()==0) 
        {
            TerrainEffect = 0;
        } 
        else if (TerrainEffectComboBox.getSelectedIndex()==1) 
        {
            TerrainEffect = 3;
        } 
        else if (TerrainEffectComboBox.getSelectedIndex()==2) 
        {
            TerrainEffect = 4;
        } 
        else if (TerrainEffectComboBox.getSelectedIndex()==3) 
        {
            TerrainEffect = 7;
        } 
        else if (TerrainEffectComboBox.getSelectedIndex()==4) 
        {
            TerrainEffect = 8;
        } 
        else if (TerrainEffectComboBox.getSelectedIndex()==5) 
        {
            TerrainEffect = 12;
        }
        Result = (PowerHWI + (((Elevation)/Power)*100) + (((Math.cos(Math.toDegrees(WindDegreePower))*WindSpeedPower)/Power)*100) + ((TerrainEffect)/Power)*100);
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        Yard = Power * Result / 100;
        DecimalFormat yDForm = new DecimalFormat("#.#");
        ResultTextField.setText(twoDForm.format(Result)+"% or "+yDForm.format(Yard)+"y");
    }

    public static void openUrl(String url){
String os = System.getProperty("os.name");
Runtime runtime=Runtime.getRuntime();
try{
    // Block for Windows Platform
    if (os.startsWith("Windows")){
    String cmd = "rundll32 url.dll,FileProtocolHandler "+ url;
    Process p = runtime.exec(cmd);
    }
    //Block for Mac OS
    else if(os.startsWith("Mac OS")){
    Class fileMgr = Class.forName("com.apple.eio.FileManager");
    Method openURL = fileMgr.getDeclaredMethod("openURL", new Class[] {String.class});
    openURL.invoke(null, new Object[] {url});
    }
    //Block for UNIX Platform
    else {
    String[] browsers = {"firefox", "opera", "konqueror", "epiphany", "mozilla", "netscape" };
    String browser = null;
    for (int count = 0; count < browsers.length && browser == null; count++)
    if (runtime.exec(new String[] {"which", browsers[count]}).waitFor() == 0)
    browser = browsers[count];
    if (browser == null)
    throw new Exception("Could not find web browser");
    else
    runtime.exec(new String[] {browser, url});
    }
    }catch(Exception x){
    System.err.println("Exception occurd while invoking Browser!");
    x.printStackTrace();
    }
}

    /** Creates new form MainFrame */
    public MainFrame() {
        Hk();
        initComponents();
        Image im = Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/images/ico.png"));
        LoadingFrame.setIconImage(im);
        AboutBox.setIconImage(im);
        CalcFrame.setIconImage(im);
        setIconImage(im);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CalcFrame = new javax.swing.JFrame();
        CalcFrameDesktopPane = new javax.swing.JDesktopPane();
        HWICalculator = new javax.swing.JLabel();
        HWIInfo = new javax.swing.JLabel();
        WindSpeedInfo = new javax.swing.JLabel();
        PBInfo = new javax.swing.JLabel();
        PowerBar = new javax.swing.JLabel();
        Degree = new javax.swing.JLabel();
        HWI = new javax.swing.JLabel();
        WindspeedpowerInfo = new javax.swing.JLabel();
        Windspeed = new javax.swing.JLabel();
        PowerCalculator = new javax.swing.JLabel();
        DegreeInfo = new javax.swing.JLabel();
        PowerInfo = new javax.swing.JLabel();
        WindspeedTextField = new javax.swing.JTextField();
        HWITextField = new javax.swing.JTextField();
        DegreeTextField = new javax.swing.JTextField();
        PbTextField = new javax.swing.JTextField();
        ElevationTextField = new javax.swing.JTextField();
        WindSpeedPowerTextField = new javax.swing.JTextField();
        PowerHWIInfo = new javax.swing.JLabel();
        PowerTextField = new javax.swing.JTextField();
        WindDegreeInfo = new javax.swing.JLabel();
        TerrainEffectInfo = new javax.swing.JLabel();
        ElevationInfo = new javax.swing.JLabel();
        ResultTextField = new javax.swing.JTextField();
        WindDegreePower = new javax.swing.JLabel();
        WindDegreePowerTextField = new javax.swing.JTextField();
        WindSpeedPower = new javax.swing.JLabel();
        Power = new javax.swing.JLabel();
        ResultInfo = new javax.swing.JLabel();
        PowerHWI = new javax.swing.JLabel();
        TerrainEffectComboBox = new javax.swing.JComboBox();
        Result = new javax.swing.JLabel();
        PowerHWITextField = new javax.swing.JTextField();
        TerrainEffect = new javax.swing.JLabel();
        Elevation = new javax.swing.JLabel();
        CalcFrameMenubar = new javax.swing.JMenuBar();
        Menu = new javax.swing.JMenu();
        Exit = new javax.swing.JMenuItem();
        URL = new javax.swing.JMenu();
        KurisutaruPC = new javax.swing.JMenuItem();
        Help = new javax.swing.JMenu();
        About = new javax.swing.JMenuItem();
        AboutBox = new javax.swing.JDialog();
        AboutBoxDesktopPane = new javax.swing.JDesktopPane();
        javax.swing.JLabel appTitleLabel = new javax.swing.JLabel();
        SpecialThanks = new javax.swing.JLabel();
        Email = new javax.swing.JLabel();
        javax.swing.JLabel appDescLabel = new javax.swing.JLabel();
        javax.swing.JLabel appVersionLabel = new javax.swing.JLabel();
        javax.swing.JLabel vendorLabel = new javax.swing.JLabel();
        close = new javax.swing.JButton();
        javax.swing.JLabel appVendorLabel = new javax.swing.JLabel();
        javax.swing.JLabel homepageLabel = new javax.swing.JLabel();
        Mystic = new javax.swing.JLabel();
        rose = new javax.swing.JLabel();
        javax.swing.JLabel versionLabel = new javax.swing.JLabel();
        javax.swing.JLabel appHomepageLabel = new javax.swing.JLabel();
        javax.swing.JLabel imageLabel = new javax.swing.JLabel();
        Xave = new javax.swing.JLabel();
        Boom = new javax.swing.JLabel();
        ST2Desc = new javax.swing.JLabel();
        javax.swing.JLabel versionLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel appVersionLabel1 = new javax.swing.JLabel();
        LoadingFrame = new javax.swing.JFrame();
        LoadingFrameDesktopPane = new javax.swing.JDesktopPane();
        LoadingBar = new javax.swing.JProgressBar();
        PercentLabel = new javax.swing.JLabel();
        MenuLabel = new javax.swing.JLabel();
        MainFrameDesktopPane = new javax.swing.JDesktopPane();
        PangYaLogo = new javax.swing.JLabel();
        DescriptionLabel = new javax.swing.JLabel();
        LoginButton = new javax.swing.JButton();
        ReadMe = new javax.swing.JLabel();
        Description = new javax.swing.JLabel();
        Changelog = new javax.swing.JLabel();
        Changelogs = new javax.swing.JLabel();

        CalcFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        CalcFrame.setTitle("Pangya! HWI Calculator");
        CalcFrame.setResizable(false);

        HWICalculator.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        HWICalculator.setForeground(new java.awt.Color(255, 255, 255));
        HWICalculator.setText("<html>HWI Calculator</html>");
        HWICalculator.setToolTipText("Calculate Horizontal Wind Effect");
        HWICalculator.setBounds(20, 10, 150, 23);
        CalcFrameDesktopPane.add(HWICalculator, javax.swing.JLayeredPane.DEFAULT_LAYER);

        HWIInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Info.png"))); // NOI18N
        HWIInfo.setToolTipText("Click to Open Help");
        HWIInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HWIInfoMouseClicked(evt);
            }
        });
        HWIInfo.setBounds(120, 120, 16, 30);
        CalcFrameDesktopPane.add(HWIInfo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        WindSpeedInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Info.png"))); // NOI18N
        WindSpeedInfo.setToolTipText("Click to Open Help");
        WindSpeedInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                WindSpeedInfoMouseClicked(evt);
            }
        });
        WindSpeedInfo.setBounds(120, 80, 16, 30);
        CalcFrameDesktopPane.add(WindSpeedInfo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        PBInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Info.png"))); // NOI18N
        PBInfo.setToolTipText("Click to Open Help");
        PBInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PBInfoMouseClicked(evt);
            }
        });
        PBInfo.setBounds(120, 160, 16, 30);
        CalcFrameDesktopPane.add(PBInfo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        PowerBar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        PowerBar.setForeground(new java.awt.Color(255, 255, 255));
        PowerBar.setText("Power Bar");
        PowerBar.setToolTipText("Power Bar");
        PowerBar.setBounds(20, 160, 90, 30);
        CalcFrameDesktopPane.add(PowerBar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        Degree.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Degree.setForeground(new java.awt.Color(255, 255, 255));
        Degree.setText("Wind Degree");
        Degree.setToolTipText("Degree");
        Degree.setBounds(20, 40, 100, 30);
        CalcFrameDesktopPane.add(Degree, javax.swing.JLayeredPane.DEFAULT_LAYER);

        HWI.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        HWI.setForeground(new java.awt.Color(255, 255, 255));
        HWI.setText("HWI");
        HWI.setToolTipText("HWI");
        HWI.setBounds(20, 120, 90, 30);
        CalcFrameDesktopPane.add(HWI, javax.swing.JLayeredPane.DEFAULT_LAYER);

        WindspeedpowerInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Info.png"))); // NOI18N
        WindspeedpowerInfo.setToolTipText("Click to Open Help");
        WindspeedpowerInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                WindspeedpowerInfoMouseClicked(evt);
            }
        });
        WindspeedpowerInfo.setBounds(120, 360, 16, 30);
        CalcFrameDesktopPane.add(WindspeedpowerInfo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        Windspeed.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Windspeed.setForeground(new java.awt.Color(255, 255, 255));
        Windspeed.setText("Wind Speed");
        Windspeed.setToolTipText("Wind Speed");
        Windspeed.setBounds(20, 80, 90, 30);
        CalcFrameDesktopPane.add(Windspeed, javax.swing.JLayeredPane.DEFAULT_LAYER);

        PowerCalculator.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        PowerCalculator.setForeground(new java.awt.Color(255, 255, 255));
        PowerCalculator.setText("<html>Power Calculator</html>");
        PowerCalculator.setToolTipText("Calculate your Power percentage");
        PowerCalculator.setBounds(20, 210, 180, 23);
        CalcFrameDesktopPane.add(PowerCalculator, javax.swing.JLayeredPane.DEFAULT_LAYER);

        DegreeInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Info.png"))); // NOI18N
        DegreeInfo.setToolTipText("Click to Open Help");
        DegreeInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DegreeInfoMouseClicked(evt);
            }
        });
        DegreeInfo.setBounds(120, 40, 16, 30);
        CalcFrameDesktopPane.add(DegreeInfo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        PowerInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Info.png"))); // NOI18N
        PowerInfo.setToolTipText("Click to Open Help");
        PowerInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PowerInfoMouseClicked(evt);
            }
        });
        PowerInfo.setBounds(120, 240, 16, 30);
        CalcFrameDesktopPane.add(PowerInfo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        WindspeedTextField.setToolTipText("Insert Wind Speed");
        WindspeedTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                WindspeedTextFieldKeyReleased(evt);
            }
        });
        WindspeedTextField.setBounds(150, 80, 170, 30);
        CalcFrameDesktopPane.add(WindspeedTextField, javax.swing.JLayeredPane.DEFAULT_LAYER);

        HWITextField.setToolTipText("Insert HWI");
        HWITextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                HWITextFieldKeyReleased(evt);
            }
        });
        HWITextField.setBounds(150, 120, 170, 30);
        CalcFrameDesktopPane.add(HWITextField, javax.swing.JLayeredPane.DEFAULT_LAYER);

        DegreeTextField.setToolTipText("Insert Wind Degree");
        DegreeTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DegreeTextFieldKeyReleased(evt);
            }
        });
        DegreeTextField.setBounds(150, 40, 170, 30);
        CalcFrameDesktopPane.add(DegreeTextField, javax.swing.JLayeredPane.DEFAULT_LAYER);

        PbTextField.setEditable(false);
        PbTextField.setToolTipText("Your Powerbar");
        PbTextField.setBounds(150, 160, 170, 30);
        CalcFrameDesktopPane.add(PbTextField, javax.swing.JLayeredPane.DEFAULT_LAYER);

        ElevationTextField.setToolTipText("Insert Elevation");
        ElevationTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ElevationTextFieldKeyReleased(evt);
            }
        });
        ElevationTextField.setBounds(150, 400, 170, 30);
        CalcFrameDesktopPane.add(ElevationTextField, javax.swing.JLayeredPane.DEFAULT_LAYER);

        WindSpeedPowerTextField.setToolTipText("Insert Windspeed");
        WindSpeedPowerTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                WindSpeedPowerTextFieldKeyReleased(evt);
            }
        });
        WindSpeedPowerTextField.setBounds(150, 360, 170, 30);
        CalcFrameDesktopPane.add(WindSpeedPowerTextField, javax.swing.JLayeredPane.DEFAULT_LAYER);

        PowerHWIInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Info.png"))); // NOI18N
        PowerHWIInfo.setToolTipText("Click to Open Help");
        PowerHWIInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PowerHWIInfoMouseClicked(evt);
            }
        });
        PowerHWIInfo.setBounds(120, 280, 16, 30);
        CalcFrameDesktopPane.add(PowerHWIInfo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        PowerTextField.setToolTipText("Insert Your Power");
        PowerTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PowerTextFieldKeyReleased(evt);
            }
        });
        PowerTextField.setBounds(150, 240, 171, 30);
        CalcFrameDesktopPane.add(PowerTextField, javax.swing.JLayeredPane.DEFAULT_LAYER);

        WindDegreeInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Info.png"))); // NOI18N
        WindDegreeInfo.setToolTipText("Click to Open Help");
        WindDegreeInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                WindDegreeInfoMouseClicked(evt);
            }
        });
        WindDegreeInfo.setBounds(120, 320, 16, 30);
        CalcFrameDesktopPane.add(WindDegreeInfo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        TerrainEffectInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Info.png"))); // NOI18N
        TerrainEffectInfo.setToolTipText("Click to Open Help");
        TerrainEffectInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TerrainEffectInfoMouseClicked(evt);
            }
        });
        TerrainEffectInfo.setBounds(120, 440, 16, 30);
        CalcFrameDesktopPane.add(TerrainEffectInfo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        ElevationInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Info.png"))); // NOI18N
        ElevationInfo.setToolTipText("Click to Open Help");
        ElevationInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ElevationInfoMouseClicked(evt);
            }
        });
        ElevationInfo.setBounds(120, 400, 16, 30);
        CalcFrameDesktopPane.add(ElevationInfo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        ResultTextField.setEditable(false);
        ResultTextField.setToolTipText("Your Result");
        ResultTextField.setBounds(150, 480, 170, 30);
        CalcFrameDesktopPane.add(ResultTextField, javax.swing.JLayeredPane.DEFAULT_LAYER);

        WindDegreePower.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        WindDegreePower.setForeground(new java.awt.Color(255, 255, 255));
        WindDegreePower.setText("Wind Degree");
        WindDegreePower.setBounds(20, 320, 90, 30);
        CalcFrameDesktopPane.add(WindDegreePower, javax.swing.JLayeredPane.DEFAULT_LAYER);

        WindDegreePowerTextField.setToolTipText("Insert Wind Degree");
        WindDegreePowerTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                WindDegreePowerTextFieldKeyReleased(evt);
            }
        });
        WindDegreePowerTextField.setBounds(150, 320, 170, 30);
        CalcFrameDesktopPane.add(WindDegreePowerTextField, javax.swing.JLayeredPane.DEFAULT_LAYER);

        WindSpeedPower.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        WindSpeedPower.setForeground(new java.awt.Color(255, 255, 255));
        WindSpeedPower.setText("Wind Speed");
        WindSpeedPower.setToolTipText("Distance");
        WindSpeedPower.setBounds(20, 360, 90, 30);
        CalcFrameDesktopPane.add(WindSpeedPower, javax.swing.JLayeredPane.DEFAULT_LAYER);

        Power.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Power.setForeground(new java.awt.Color(255, 255, 255));
        Power.setText("Power");
        Power.setToolTipText("Power");
        Power.setBounds(20, 240, 90, 30);
        CalcFrameDesktopPane.add(Power, javax.swing.JLayeredPane.DEFAULT_LAYER);

        ResultInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Info.png"))); // NOI18N
        ResultInfo.setToolTipText("Click to Open Help");
        ResultInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResultInfoMouseClicked(evt);
            }
        });
        ResultInfo.setBounds(120, 480, 16, 30);
        CalcFrameDesktopPane.add(ResultInfo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        PowerHWI.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        PowerHWI.setForeground(new java.awt.Color(255, 255, 255));
        PowerHWI.setText("Power HWI");
        PowerHWI.setBounds(20, 280, 90, 30);
        CalcFrameDesktopPane.add(PowerHWI, javax.swing.JLayeredPane.DEFAULT_LAYER);

        TerrainEffectComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "100% [Fairway, Ice]", "98% [Raining]", "95% [Rough]", "92% [Rough + Raining]", "90% [Rough, Bunker]", "85% [Bunker]" }));
        TerrainEffectComboBox.setToolTipText("Select Terrain Effect");
        TerrainEffectComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TerrainEffectComboBoxItemStateChanged(evt);
            }
        });
        TerrainEffectComboBox.setBounds(150, 440, 170, 30);
        CalcFrameDesktopPane.add(TerrainEffectComboBox, javax.swing.JLayeredPane.DEFAULT_LAYER);

        Result.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Result.setForeground(new java.awt.Color(255, 255, 255));
        Result.setText("Result");
        Result.setToolTipText("Result");
        Result.setBounds(20, 480, 90, 30);
        CalcFrameDesktopPane.add(Result, javax.swing.JLayeredPane.DEFAULT_LAYER);

        PowerHWITextField.setToolTipText("Insert Power from HWI Table");
        PowerHWITextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PowerHWITextFieldKeyReleased(evt);
            }
        });
        PowerHWITextField.setBounds(150, 280, 171, 30);
        CalcFrameDesktopPane.add(PowerHWITextField, javax.swing.JLayeredPane.DEFAULT_LAYER);

        TerrainEffect.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        TerrainEffect.setForeground(new java.awt.Color(255, 255, 255));
        TerrainEffect.setText("Terrain Effect");
        TerrainEffect.setToolTipText("Terrain Effect");
        TerrainEffect.setBounds(20, 440, 90, 30);
        CalcFrameDesktopPane.add(TerrainEffect, javax.swing.JLayeredPane.DEFAULT_LAYER);

        Elevation.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Elevation.setForeground(new java.awt.Color(255, 255, 255));
        Elevation.setText("Elevation");
        Elevation.setToolTipText("Elevation");
        Elevation.setBounds(20, 400, 90, 30);
        CalcFrameDesktopPane.add(Elevation, javax.swing.JLayeredPane.DEFAULT_LAYER);

        Menu.setText("Menu");
        Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuActionPerformed(evt);
            }
        });

        Exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        Menu.add(Exit);

        CalcFrameMenubar.add(Menu);

        URL.setText("Useful Links");

        KurisutaruPC.setText("Kurisutaru's Personal Site");
        KurisutaruPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KurisutaruPCActionPerformed(evt);
            }
        });
        URL.add(KurisutaruPC);

        CalcFrameMenubar.add(URL);

        Help.setText("Help");

        About.setText("About");
        About.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutActionPerformed(evt);
            }
        });
        Help.add(About);

        CalcFrameMenubar.add(Help);

        CalcFrame.setJMenuBar(CalcFrameMenubar);

        javax.swing.GroupLayout CalcFrameLayout = new javax.swing.GroupLayout(CalcFrame.getContentPane());
        CalcFrame.getContentPane().setLayout(CalcFrameLayout);
        CalcFrameLayout.setHorizontalGroup(
            CalcFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CalcFrameDesktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
        );
        CalcFrameLayout.setVerticalGroup(
            CalcFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CalcFrameDesktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        AboutBox.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        AboutBox.setTitle("About : Pangya! HWI Calculator 1.2");
        AboutBox.setModal(true);
        AboutBox.setResizable(false);

        AboutBoxDesktopPane.setBackground(new java.awt.Color(0, 102, 204));

        appTitleLabel.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        appTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        appTitleLabel.setText("Pangya! HWI Calculator");
        appTitleLabel.setBounds(260, 10, 370, 30);
        AboutBoxDesktopPane.add(appTitleLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        SpecialThanks.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        SpecialThanks.setForeground(new java.awt.Color(255, 255, 255));
        SpecialThanks.setText("Special Thanks :");
        SpecialThanks.setBounds(260, 140, 120, 30);
        AboutBoxDesktopPane.add(SpecialThanks, javax.swing.JLayeredPane.DEFAULT_LAYER);

        Email.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Email.setForeground(new java.awt.Color(255, 255, 255));
        Email.setText("Hk_Heaven_Kingdom@yahoo.com");
        Email.setBounds(390, 120, 240, 30);
        AboutBoxDesktopPane.add(Email, javax.swing.JLayeredPane.DEFAULT_LAYER);

        appDescLabel.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        appDescLabel.setForeground(new java.awt.Color(255, 255, 255));
        appDescLabel.setText("A simple Calculator that calculate HWI Adjustment");
        appDescLabel.setBounds(260, 40, 380, 20);
        AboutBoxDesktopPane.add(appDescLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        appVersionLabel.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        appVersionLabel.setForeground(new java.awt.Color(255, 255, 255));
        appVersionLabel.setText("1.2");
        appVersionLabel.setBounds(390, 100, 170, 30);
        AboutBoxDesktopPane.add(appVersionLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        vendorLabel.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        vendorLabel.setForeground(new java.awt.Color(255, 255, 255));
        vendorLabel.setText("Creator :");
        vendorLabel.setBounds(260, 60, 120, 30);
        AboutBoxDesktopPane.add(vendorLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        close.setText("Close");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        close.setBounds(510, 300, 70, 30);
        AboutBoxDesktopPane.add(close, javax.swing.JLayeredPane.DEFAULT_LAYER);

        appVendorLabel.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        appVendorLabel.setForeground(new java.awt.Color(255, 255, 255));
        appVendorLabel.setText("Kurisutaru.");
        appVendorLabel.setBounds(390, 60, 170, 30);
        AboutBoxDesktopPane.add(appVendorLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        homepageLabel.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        homepageLabel.setForeground(new java.awt.Color(255, 255, 255));
        homepageLabel.setText("Email :");
        homepageLabel.setBounds(260, 120, 120, 30);
        AboutBoxDesktopPane.add(homepageLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        Mystic.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        Mystic.setForeground(new java.awt.Color(255, 255, 255));
        Mystic.setText("MySTiC");
        Mystic.setBounds(390, 140, 50, 40);
        AboutBoxDesktopPane.add(Mystic, javax.swing.JLayeredPane.DEFAULT_LAYER);

        rose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/039.gif"))); // NOI18N
        rose.setBounds(440, 140, 26, 30);
        AboutBoxDesktopPane.add(rose, javax.swing.JLayeredPane.DEFAULT_LAYER);

        versionLabel.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        versionLabel.setForeground(new java.awt.Color(255, 255, 255));
        versionLabel.setText("Calc Version :");
        versionLabel.setBounds(260, 100, 120, 30);
        AboutBoxDesktopPane.add(versionLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        versionLabel.getAccessibleContext().setAccessibleName("Calc Version:");

        appHomepageLabel.setBounds(0, 0, 0, 0);
        AboutBoxDesktopPane.add(appHomepageLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/aboutme.png"))); // NOI18N
        imageLabel.setBounds(0, 0, 237, 352);
        AboutBoxDesktopPane.add(imageLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        Xave.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        Xave.setForeground(new java.awt.Color(255, 255, 255));
        Xave.setText("<html>montz</html>");
        Xave.setBounds(390, 170, 40, 30);
        AboutBoxDesktopPane.add(Xave, javax.swing.JLayeredPane.DEFAULT_LAYER);

        Boom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/056.gif"))); // NOI18N
        Boom.setBounds(430, 170, 30, 30);
        AboutBoxDesktopPane.add(Boom, javax.swing.JLayeredPane.DEFAULT_LAYER);

        ST2Desc.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        ST2Desc.setForeground(new java.awt.Color(255, 255, 255));
        ST2Desc.setText("<html>[PY-US United Tester]</html>");
        ST2Desc.setBounds(460, 170, 140, 30);
        AboutBoxDesktopPane.add(ST2Desc, javax.swing.JLayeredPane.DEFAULT_LAYER);

        versionLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        versionLabel1.setForeground(new java.awt.Color(255, 255, 255));
        versionLabel1.setText("Website :");
        versionLabel1.setBounds(260, 80, 120, 30);
        AboutBoxDesktopPane.add(versionLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        appVersionLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        appVersionLabel1.setForeground(new java.awt.Color(255, 255, 255));
        appVersionLabel1.setText("http://www.kurisutaru.net/");
        appVersionLabel1.setBounds(390, 80, 210, 30);
        AboutBoxDesktopPane.add(appVersionLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout AboutBoxLayout = new javax.swing.GroupLayout(AboutBox.getContentPane());
        AboutBox.getContentPane().setLayout(AboutBoxLayout);
        AboutBoxLayout.setHorizontalGroup(
            AboutBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AboutBoxDesktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
        );
        AboutBoxLayout.setVerticalGroup(
            AboutBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AboutBoxDesktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        AboutBox.getAccessibleContext().setAccessibleName("About : Pangya! HWI Calculator 1.2");

        LoadingFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        LoadingFrame.setResizable(false);
        LoadingFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                LoadingFrameWindowActivated(evt);
            }
        });

        LoadingBar.setBounds(10, 40, 330, 16);
        LoadingFrameDesktopPane.add(LoadingBar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        PercentLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PercentLabel.setForeground(new java.awt.Color(255, 255, 255));
        PercentLabel.setText("0 %");
        PercentLabel.setBounds(350, 30, 60, 30);
        LoadingFrameDesktopPane.add(PercentLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        MenuLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        MenuLabel.setForeground(new java.awt.Color(255, 255, 255));
        MenuLabel.setText("Load Settings....");
        MenuLabel.setBounds(10, 10, 340, 21);
        LoadingFrameDesktopPane.add(MenuLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout LoadingFrameLayout = new javax.swing.GroupLayout(LoadingFrame.getContentPane());
        LoadingFrame.getContentPane().setLayout(LoadingFrameLayout);
        LoadingFrameLayout.setHorizontalGroup(
            LoadingFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LoadingFrameDesktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
        );
        LoadingFrameLayout.setVerticalGroup(
            LoadingFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LoadingFrameDesktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pangya! HWI Calculator");
        setResizable(false);

        MainFrameDesktopPane.setBackground(new java.awt.Color(51, 102, 255));
        MainFrameDesktopPane.setPreferredSize(new java.awt.Dimension(449, 271));

        PangYaLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Banner.png"))); // NOI18N
        PangYaLogo.setToolTipText("Click to Open");
        PangYaLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PangYaLogoMouseClicked(evt);
            }
        });
        PangYaLogo.setBounds(0, 0, 450, 140);
        MainFrameDesktopPane.add(PangYaLogo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        DescriptionLabel.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        DescriptionLabel.setForeground(new java.awt.Color(255, 255, 255));
        DescriptionLabel.setText("HWI Calculator by Alcatrazz aka Kurisutaru");
        DescriptionLabel.setBounds(130, 150, 310, 16);
        MainFrameDesktopPane.add(DescriptionLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        LoginButton.setText("Launch");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        LoginButton.setBounds(160, 400, 140, 30);
        MainFrameDesktopPane.add(LoginButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        ReadMe.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        ReadMe.setForeground(new java.awt.Color(255, 255, 255));
        ReadMe.setText("Read Me First !");
        ReadMe.setBounds(30, 180, 390, 20);
        MainFrameDesktopPane.add(ReadMe, javax.swing.JLayeredPane.DEFAULT_LAYER);

        Description.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Description.setForeground(new java.awt.Color(255, 255, 255));
        Description.setText("<html>There is no perfect calculation. This tools only help you calculate hwi if you DONT have Scientific calculator (like me).<br>Use this calc is easy, just input everythings in box and Calculation will show up</html>");
        Description.setBounds(30, 200, 390, 70);
        MainFrameDesktopPane.add(Description, javax.swing.JLayeredPane.DEFAULT_LAYER);

        Changelog.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Changelog.setForeground(new java.awt.Color(255, 255, 255));
        Changelog.setText("Changelogs");
        Changelog.setBounds(30, 270, 360, 30);
        MainFrameDesktopPane.add(Changelog, javax.swing.JLayeredPane.DEFAULT_LAYER);

        Changelogs.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Changelogs.setForeground(new java.awt.Color(255, 255, 255));
        Changelogs.setText("<html>- Edited Skin<br /> - Re-fix Power Calculation for Wind Effect<br/>- Optimizing Code for Faster load and reduce memory usage<br />- Change to Auto Calculation, so you will not press Enter Key anymore</html>");
        Changelogs.setBounds(30, 300, 400, 80);
        MainFrameDesktopPane.add(Changelogs, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainFrameDesktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainFrameDesktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
       AboutBox.dispose();
    }//GEN-LAST:event_closeActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void AboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutActionPerformed
        AboutBox.setTitle("About : Pangya! HWI Calculator 1.2");
        AboutBox.setSize(625, 377);
        AboutBox.show();
    }//GEN-LAST:event_AboutActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
      
            CalcFrame.setSize(345, 580);
            CalcFrame.setVisible(true);
            setVisible(false);

    }//GEN-LAST:event_LoginButtonActionPerformed

    private void MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    private void LoadingFrameWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_LoadingFrameWindowActivated
    
        timer = new Timer(50, new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              
              
              if (i == 1)
              {
                    LoadingFrame.setTitle("PangYa HWI Calculator - Connecting . . .");
                    MenuLabel.setText("Connecting to Authentication Server . . .");
              }
              if(i == 25)
              {
                  LoadingFrame.setTitle("PangYa HWI Calculator - Verifiying . . .");
                    MenuLabel.setText("Verifiying Username and Password . . .");
              }
              if (i == 50)
              {
                    LoadingFrame.setTitle("PangYa HWI Calculator - Downloading . . .");
                    MenuLabel.setText("Downloading User Setting . . .");
              }
              if (i == 75)
              {
                    LoadingFrame.setTitle("PangYa HWI Calculator - Loading . . .");
                    MenuLabel.setText("Loading User Setting . . .");
              }
              if (i == 98)
              {
                    LoadingFrame.setTitle("PangYa HWI Calculator - Loading Complete . . .");
                    MenuLabel.setText("Loading Complete . . .");
              }
              if (i == 100){
                timer.stop();
                LoadingFrame.setVisible(false);
                CalcFrame.setSize(345,580);
                CalcFrame.show();

              }
              else {
                    i++;
                    Integer a = i;
                    PercentLabel.setText(a.toString() + " %");
                    LoadingBar.setValue(i);

                }
          
            }
       });
       timer.start();


    }//GEN-LAST:event_LoadingFrameWindowActivated

    private void PowerInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PowerInfoMouseClicked
        JOptionPane.showMessageDialog(this, "Power that you have.Example : 1W = 250y, \nyou write down 250 and 1W + Power = 260, \nthen write down 260", "Help Center", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_PowerInfoMouseClicked

    private void PowerHWIInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PowerHWIInfoMouseClicked
       JOptionPane.showMessageDialog(this, "Power that provided on HWI table", "Help Center", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_PowerHWIInfoMouseClicked

    private void WindDegreeInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WindDegreeInfoMouseClicked
        JOptionPane.showMessageDialog(this, "Indicate where the wind blow", "Help Center", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_WindDegreeInfoMouseClicked

    private void ElevationInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ElevationInfoMouseClicked
        JOptionPane.showMessageDialog(this, "Elevation from Your position and position of the hole cup", "Help Center", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_ElevationInfoMouseClicked

    private void TerrainEffectInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TerrainEffectInfoMouseClicked
        JOptionPane.showMessageDialog(this, "Terrain means Status of you ball (Usually Percentage)", "Help Center", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_TerrainEffectInfoMouseClicked

    private void ResultInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResultInfoMouseClicked
        JOptionPane.showMessageDialog(this, "Final Calculation for you Power usage", "Help Center", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_ResultInfoMouseClicked

    private void PBInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PBInfoMouseClicked
        JOptionPane.showMessageDialog(this, "Final calculation for HWI (Pb means Power Bar)", "Help Center", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_PBInfoMouseClicked

    private void HWIInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HWIInfoMouseClicked
        JOptionPane.showMessageDialog(this, "HWI Modifier that provided at HWI Table", "Help Center", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_HWIInfoMouseClicked

    private void WindSpeedInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WindSpeedInfoMouseClicked
        JOptionPane.showMessageDialog(this, "Wind Speed value (xm)", "Help Center", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_WindSpeedInfoMouseClicked

    private void DegreeInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DegreeInfoMouseClicked
        JOptionPane.showMessageDialog(this, "Indicate where the wind blow", "Help Center", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_DegreeInfoMouseClicked

    private void WindspeedpowerInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WindspeedpowerInfoMouseClicked
        JOptionPane.showMessageDialog(this, "Indicate how fast the wind blow, Use negative value for Tailwind !", "Help Center", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_WindspeedpowerInfoMouseClicked

    private void PangYaLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PangYaLogoMouseClicked
        openUrl("http://www.Kurisutaru.net/");
    }//GEN-LAST:event_PangYaLogoMouseClicked

    private void KurisutaruPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KurisutaruPCActionPerformed
        openUrl("http://www.Kurisutaru.net/");
    }//GEN-LAST:event_KurisutaruPCActionPerformed

    private void DegreeTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DegreeTextFieldKeyReleased
        try {
                HWICalc();
        } catch(Exception E) {

        }
    }//GEN-LAST:event_DegreeTextFieldKeyReleased

    private void WindspeedTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_WindspeedTextFieldKeyReleased
        try {
                HWICalc();
        } catch(Exception E) {

        }
    }//GEN-LAST:event_WindspeedTextFieldKeyReleased

    private void HWITextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_HWITextFieldKeyReleased
        try {
                HWICalc();
        } catch(Exception E) {

        }
    }//GEN-LAST:event_HWITextFieldKeyReleased

    private void PowerTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PowerTextFieldKeyReleased
        try {
                PowerCalc();
        } catch(Exception E) {

        }
    }//GEN-LAST:event_PowerTextFieldKeyReleased

    private void PowerHWITextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PowerHWITextFieldKeyReleased
        try {
                PowerCalc();
        } catch(Exception E) {

        }
    }//GEN-LAST:event_PowerHWITextFieldKeyReleased

    private void WindDegreePowerTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_WindDegreePowerTextFieldKeyReleased
        try {
                PowerCalc();
        } catch(Exception E) {

        }
    }//GEN-LAST:event_WindDegreePowerTextFieldKeyReleased

    private void WindSpeedPowerTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_WindSpeedPowerTextFieldKeyReleased
        try {
                PowerCalc();
        } catch(Exception E) {

        }
    }//GEN-LAST:event_WindSpeedPowerTextFieldKeyReleased

    private void ElevationTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ElevationTextFieldKeyReleased
         try {
                PowerCalc();
        } catch(Exception E) {

        }
    }//GEN-LAST:event_ElevationTextFieldKeyReleased

    private void TerrainEffectComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TerrainEffectComboBoxItemStateChanged
        try {
                PowerCalc();
        } catch(Exception E) {

        }
    }//GEN-LAST:event_TerrainEffectComboBoxItemStateChanged

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem About;
    private javax.swing.JDialog AboutBox;
    private javax.swing.JDesktopPane AboutBoxDesktopPane;
    private javax.swing.JLabel Boom;
    private javax.swing.JFrame CalcFrame;
    private javax.swing.JDesktopPane CalcFrameDesktopPane;
    private javax.swing.JMenuBar CalcFrameMenubar;
    private javax.swing.JLabel Changelog;
    private javax.swing.JLabel Changelogs;
    private javax.swing.JLabel Degree;
    private javax.swing.JLabel DegreeInfo;
    private javax.swing.JTextField DegreeTextField;
    private javax.swing.JLabel Description;
    private javax.swing.JLabel DescriptionLabel;
    private javax.swing.JLabel Elevation;
    private javax.swing.JLabel ElevationInfo;
    private javax.swing.JTextField ElevationTextField;
    private javax.swing.JLabel Email;
    private javax.swing.JMenuItem Exit;
    private javax.swing.JLabel HWI;
    private javax.swing.JLabel HWICalculator;
    private javax.swing.JLabel HWIInfo;
    private javax.swing.JTextField HWITextField;
    private javax.swing.JMenu Help;
    private javax.swing.JMenuItem KurisutaruPC;
    private javax.swing.JProgressBar LoadingBar;
    private javax.swing.JFrame LoadingFrame;
    private javax.swing.JDesktopPane LoadingFrameDesktopPane;
    private javax.swing.JButton LoginButton;
    private javax.swing.JDesktopPane MainFrameDesktopPane;
    private javax.swing.JMenu Menu;
    private javax.swing.JLabel MenuLabel;
    private javax.swing.JLabel Mystic;
    private javax.swing.JLabel PBInfo;
    private javax.swing.JLabel PangYaLogo;
    private javax.swing.JTextField PbTextField;
    private javax.swing.JLabel PercentLabel;
    private javax.swing.JLabel Power;
    private javax.swing.JLabel PowerBar;
    private javax.swing.JLabel PowerCalculator;
    private javax.swing.JLabel PowerHWI;
    private javax.swing.JLabel PowerHWIInfo;
    private javax.swing.JTextField PowerHWITextField;
    private javax.swing.JLabel PowerInfo;
    private javax.swing.JTextField PowerTextField;
    private javax.swing.JLabel ReadMe;
    private javax.swing.JLabel Result;
    private javax.swing.JLabel ResultInfo;
    private javax.swing.JTextField ResultTextField;
    private javax.swing.JLabel ST2Desc;
    private javax.swing.JLabel SpecialThanks;
    private javax.swing.JLabel TerrainEffect;
    private javax.swing.JComboBox TerrainEffectComboBox;
    private javax.swing.JLabel TerrainEffectInfo;
    private javax.swing.JMenu URL;
    private javax.swing.JLabel WindDegreeInfo;
    private javax.swing.JLabel WindDegreePower;
    private javax.swing.JTextField WindDegreePowerTextField;
    private javax.swing.JLabel WindSpeedInfo;
    private javax.swing.JLabel WindSpeedPower;
    private javax.swing.JTextField WindSpeedPowerTextField;
    private javax.swing.JLabel Windspeed;
    private javax.swing.JTextField WindspeedTextField;
    private javax.swing.JLabel WindspeedpowerInfo;
    private javax.swing.JLabel Xave;
    private javax.swing.JButton close;
    private javax.swing.JLabel rose;
    // End of variables declaration//GEN-END:variables

        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

}
