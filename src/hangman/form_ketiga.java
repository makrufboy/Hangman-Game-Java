/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author AFIF MAKRUF
 */
public class form_ketiga extends javax.swing.JFrame{

    /**
     * Creates new form form_ketiga
     */
    GameLogic game = new GameLogic();
    Database db = new Database();
    //variabel test string builder
//    private StringBuilder mask = new StringBuilder();
//    private Handlers handler ;
    public form_ketiga() {
        
        initComponents();

        setTitle("Form Awal");
        

        initialize();
        listener();
        setExtendedState(JFrame.MAXIMIZED_HORIZ);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void initialize(){
        labelA.setVisible(false);
        labelB.setVisible(false);
        labelC.setVisible(false);
        labelD.setVisible(false);
        labelE.setVisible(false);
        labelF.setVisible(false);
        labelG.setVisible(false);
        labelH.setVisible(false);
        labelI.setVisible(false);
        labelJ.setVisible(false);
        labelK.setVisible(false);
        labelL.setVisible(false);
        labelM.setVisible(false);
        labelN.setVisible(false);
        labelO.setVisible(false);
        labelP.setVisible(false);
        labelQ.setVisible(false);
        labelR.setVisible(false);
        labelS.setVisible(false);
        labelT.setVisible(false);
        labelU.setVisible(false);
        labelV.setVisible(false);
        labelW.setVisible(false);
        labelX.setVisible(false);
        labelY.setVisible(false);
        labelZ.setVisible(false);
        
        hangman1.setVisible(false);
        hangman2.setVisible(false);
        hangman3.setVisible(false);
        hangman4.setVisible(false);
        hangman5.setVisible(false);
        hangman6.setVisible(false);
        hangman7.setVisible(false);
        hangman8.setVisible(false);
        hangman9.setVisible(false);
        hangman10.setVisible(false);
        
        game.gameInProgress(false);
        
        selectedName.setText(game.getUserName());
        score.setText(""+ game.getPoints());
       
    }
    
    public void newWord(){
        if(game.getState() == false){
     
            labelA.setVisible(true);
            labelB.setVisible(true);
            labelC.setVisible(true);
            labelD.setVisible(true);
            labelE.setVisible(true);
            labelF.setVisible(true);
            labelG.setVisible(true);
            labelH.setVisible(true);
            labelI.setVisible(true);
            labelJ.setVisible(true);
            labelK.setVisible(true);
            labelL.setVisible(true);
            labelM.setVisible(true);
            labelN.setVisible(true);
            labelO.setVisible(true);
            labelP.setVisible(true);
            labelQ.setVisible(true);
            labelR.setVisible(true);
            labelS.setVisible(true);
            labelT.setVisible(true);
            labelU.setVisible(true);
            labelV.setVisible(true);
            labelW.setVisible(true);
            labelX.setVisible(true);
            labelY.setVisible(true);
            labelZ.setVisible(true);
            
            
            game.setCategory(selectCategory.getSelectedItem().toString());
            game.setRandomWord();
            game.gameInProgress(true);
            game.setCompletion(false);
            mark.setText(game.getMask());
            game.runningGame++;
        }
    }
    
    public void makeGuess(MouseEvent e){
        JLabel selectedLabel = new JLabel();
        selectedLabel = (JLabel) e.getSource();
        
        
        if(game.checkLetter(selectedLabel.getText())){
            game.updateMask(selectedLabel.getText());
            mark.setText(game.getMask());
//            
            ((JLabel) e.getSource()).setVisible(false);
            //game telah selesai
            if(game.checkCompletion()){
                mark.setText(game.getSelectedWord());
                
                
//                game.gameInProgress(false);
                game.resetLives();
                game.resetMask();
                initialize();
                game.running(game.runningGame);
                
            }
        }else{
            game.hangMan();
            
            if(game.hangManState() < 10){
                ((JLabel) e.getSource()).setVisible(false);
                
                if(game.hangManState() == 1){
                    hangman1.setVisible(true);
                }else if(game.hangManState() == 2){
                    hangman2.setVisible(true);
                }else if(game.hangManState() == 3){
                    hangman3.setVisible(true);
                }else if(game.hangManState() == 4){
                    hangman4.setVisible(true);
                }else if(game.hangManState() == 5){
                    hangman5.setVisible(true);
                }else if(game.hangManState() == 6){
                    hangman6.setVisible(true);
                }else if(game.hangManState() == 7){
                    hangman7.setVisible(true);
                }else if(game.hangManState() == 8){
                    hangman8.setVisible(true);
                }else if(game.hangManState() == 9){
                    hangman9.setVisible(true);
                }
                
            }else{
                hangman10.setVisible(true);
                mark.setText(game.getSelectedWord());
                game.resetLives();
                game.resetMask();
                initialize();
                db.setScore(game.getPoints());
//                game.gameInProgress(false);
                game.resetPoints();
            }
        }
    }
    
    
    public void listener(){
        
        labelA.addMouseListener(new java.awt.event.MouseAdapter() {
        
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            makeGuess(evt);
            
        }
        });
        labelB.addMouseListener(new java.awt.event.MouseAdapter() {
        
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            makeGuess(evt);
            
        }
        });
        labelC.addMouseListener(new java.awt.event.MouseAdapter() {
        
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            makeGuess(evt);
            
        }
        });
        labelD.addMouseListener(new java.awt.event.MouseAdapter() {
        
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            makeGuess(evt);
            
        }
        });
        labelE.addMouseListener(new java.awt.event.MouseAdapter() {
        
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            makeGuess(evt);
            
        }
        });
        labelF.addMouseListener(new java.awt.event.MouseAdapter() {
        
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            makeGuess(evt);
            
        }
        });
        labelG.addMouseListener(new java.awt.event.MouseAdapter() {
        
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            makeGuess(evt);
            
        }
        });
        labelH.addMouseListener(new java.awt.event.MouseAdapter() {
        
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            makeGuess(evt);
            
        }
        });
        labelI.addMouseListener(new java.awt.event.MouseAdapter() {
        
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            makeGuess(evt);
            
        }
        });
        labelJ.addMouseListener(new java.awt.event.MouseAdapter() {
        
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            makeGuess(evt);
            
        }
        });
        labelK.addMouseListener(new java.awt.event.MouseAdapter() {
        
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            makeGuess(evt);
            
        }
        });
        labelL.addMouseListener(new java.awt.event.MouseAdapter() {
        
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            makeGuess(evt);
            
        }
        });
        labelM.addMouseListener(new java.awt.event.MouseAdapter() {
        
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            makeGuess(evt);
            
        }
        });
        labelN.addMouseListener(new java.awt.event.MouseAdapter() {
        
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            makeGuess(evt);
            
        }
        });
        labelO.addMouseListener(new java.awt.event.MouseAdapter() {
        
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            makeGuess(evt);
            
        }
        });
        labelP.addMouseListener(new java.awt.event.MouseAdapter() {
        
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            makeGuess(evt);
            
        }
        });
        labelQ.addMouseListener(new java.awt.event.MouseAdapter() {
        
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            makeGuess(evt);
            
        }
        });
        labelR.addMouseListener(new java.awt.event.MouseAdapter() {
        
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            makeGuess(evt);
            
        }
        });
        labelS.addMouseListener(new java.awt.event.MouseAdapter() {
        
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            makeGuess(evt);
            
        }
        });
        labelT.addMouseListener(new java.awt.event.MouseAdapter() {
        
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            makeGuess(evt);
            
        }
        });
        labelU.addMouseListener(new java.awt.event.MouseAdapter() {
        
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            makeGuess(evt);
            
        }
        });
        labelV.addMouseListener(new java.awt.event.MouseAdapter() {
        
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            makeGuess(evt);
            
        }
        });
        labelW.addMouseListener(new java.awt.event.MouseAdapter() {
        
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            makeGuess(evt);
            
        }
        });
        labelX.addMouseListener(new java.awt.event.MouseAdapter() {
        
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            makeGuess(evt);
            
        }
        });
        labelY.addMouseListener(new java.awt.event.MouseAdapter() {
        
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            makeGuess(evt);
            
        }
        });
        labelZ.addMouseListener(new java.awt.event.MouseAdapter() {
        
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            makeGuess(evt);
            
        }
        });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        selectedName = new javax.swing.JLabel();
        labelC = new javax.swing.JLabel();
        labelA = new javax.swing.JLabel();
        labelD = new javax.swing.JLabel();
        labelT = new javax.swing.JLabel();
        labelX = new javax.swing.JLabel();
        labelY = new javax.swing.JLabel();
        labelZ = new javax.swing.JLabel();
        labelQ = new javax.swing.JLabel();
        labelR = new javax.swing.JLabel();
        labelP = new javax.swing.JLabel();
        labelS = new javax.swing.JLabel();
        labelM = new javax.swing.JLabel();
        labelN = new javax.swing.JLabel();
        labelO = new javax.swing.JLabel();
        labelB = new javax.swing.JLabel();
        labelE = new javax.swing.JLabel();
        labelF = new javax.swing.JLabel();
        labelG = new javax.swing.JLabel();
        labelH = new javax.swing.JLabel();
        labelI = new javax.swing.JLabel();
        labelJ = new javax.swing.JLabel();
        labelK = new javax.swing.JLabel();
        labelL = new javax.swing.JLabel();
        labelU = new javax.swing.JLabel();
        labelV = new javax.swing.JLabel();
        labelW = new javax.swing.JLabel();
        selectCategory = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        score = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        mark = new javax.swing.JLabel();
        hangman10 = new javax.swing.JLabel();
        hangman9 = new javax.swing.JLabel();
        hangman8 = new javax.swing.JLabel();
        hangman7 = new javax.swing.JLabel();
        hangman6 = new javax.swing.JLabel();
        hangman5 = new javax.swing.JLabel();
        hangman4 = new javax.swing.JLabel();
        hangman3 = new javax.swing.JLabel();
        hangman2 = new javax.swing.JLabel();
        hangman1 = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Chiller", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 102));
        jLabel2.setText("GUESS THE WORD!");
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jLabel2);
        jLabel2.setBounds(50, 70, 140, 40);

        jLabel3.setFont(new java.awt.Font("Chiller", 1, 45)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 51));
        jLabel3.setText(" HANGMAN ");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 20, 200, 60);

        selectedName.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        selectedName.setForeground(new java.awt.Color(255, 255, 255));
        selectedName.setText("Username");
        jPanel2.add(selectedName);
        selectedName.setBounds(100, 180, 90, 17);

        labelC.setBackground(new java.awt.Color(153, 153, 255));
        labelC.setFont(new java.awt.Font("Chiller", 1, 66)); // NOI18N
        labelC.setForeground(new java.awt.Color(255, 255, 255));
        labelC.setText("c");
        jPanel2.add(labelC);
        labelC.setBounds(360, 30, 40, 50);

        labelA.setBackground(new java.awt.Color(153, 153, 255));
        labelA.setFont(new java.awt.Font("Chiller", 1, 66)); // NOI18N
        labelA.setForeground(new java.awt.Color(255, 255, 255));
        labelA.setText("a");
        jPanel2.add(labelA);
        labelA.setBounds(240, 30, 40, 50);

        labelD.setBackground(new java.awt.Color(153, 153, 255));
        labelD.setFont(new java.awt.Font("Chiller", 1, 66)); // NOI18N
        labelD.setForeground(new java.awt.Color(255, 255, 255));
        labelD.setText("d");
        jPanel2.add(labelD);
        labelD.setBounds(410, 40, 40, 50);

        labelT.setBackground(new java.awt.Color(153, 153, 255));
        labelT.setFont(new java.awt.Font("Chiller", 1, 66)); // NOI18N
        labelT.setForeground(new java.awt.Color(255, 255, 255));
        labelT.setText("t");
        jPanel2.add(labelT);
        labelT.setBounds(370, 250, 40, 50);

        labelX.setBackground(new java.awt.Color(153, 153, 255));
        labelX.setFont(new java.awt.Font("Chiller", 1, 66)); // NOI18N
        labelX.setForeground(new java.awt.Color(255, 255, 255));
        labelX.setText("x");
        jPanel2.add(labelX);
        labelX.setBounds(330, 310, 40, 50);

        labelY.setBackground(new java.awt.Color(153, 153, 255));
        labelY.setFont(new java.awt.Font("Chiller", 1, 66)); // NOI18N
        labelY.setForeground(new java.awt.Color(255, 255, 255));
        labelY.setText("y");
        jPanel2.add(labelY);
        labelY.setBounds(370, 300, 50, 70);

        labelZ.setBackground(new java.awt.Color(153, 153, 255));
        labelZ.setFont(new java.awt.Font("Chiller", 1, 66)); // NOI18N
        labelZ.setForeground(new java.awt.Color(255, 255, 255));
        labelZ.setText("z");
        jPanel2.add(labelZ);
        labelZ.setBounds(420, 310, 40, 50);

        labelQ.setBackground(new java.awt.Color(153, 153, 255));
        labelQ.setFont(new java.awt.Font("Chiller", 1, 66)); // NOI18N
        labelQ.setForeground(new java.awt.Color(255, 255, 255));
        labelQ.setText("q");
        jPanel2.add(labelQ);
        labelQ.setBounds(240, 230, 50, 80);

        labelR.setBackground(new java.awt.Color(153, 153, 255));
        labelR.setFont(new java.awt.Font("Chiller", 1, 66)); // NOI18N
        labelR.setForeground(new java.awt.Color(255, 255, 255));
        labelR.setText("r");
        jPanel2.add(labelR);
        labelR.setBounds(290, 250, 40, 50);

        labelP.setBackground(new java.awt.Color(153, 153, 255));
        labelP.setFont(new java.awt.Font("Chiller", 1, 66)); // NOI18N
        labelP.setForeground(new java.awt.Color(255, 255, 255));
        labelP.setText("p");
        jPanel2.add(labelP);
        labelP.setBounds(420, 200, 40, 50);

        labelS.setBackground(new java.awt.Color(153, 153, 255));
        labelS.setFont(new java.awt.Font("Chiller", 1, 66)); // NOI18N
        labelS.setForeground(new java.awt.Color(255, 255, 255));
        labelS.setText("s");
        jPanel2.add(labelS);
        labelS.setBounds(330, 250, 40, 50);

        labelM.setBackground(new java.awt.Color(153, 153, 255));
        labelM.setFont(new java.awt.Font("Chiller", 1, 66)); // NOI18N
        labelM.setForeground(new java.awt.Color(255, 255, 255));
        labelM.setText("m");
        jPanel2.add(labelM);
        labelM.setBounds(240, 190, 40, 50);

        labelN.setBackground(new java.awt.Color(153, 153, 255));
        labelN.setFont(new java.awt.Font("Chiller", 1, 66)); // NOI18N
        labelN.setForeground(new java.awt.Color(255, 255, 255));
        labelN.setText("n");
        jPanel2.add(labelN);
        labelN.setBounds(300, 190, 40, 50);

        labelO.setBackground(new java.awt.Color(153, 153, 255));
        labelO.setFont(new java.awt.Font("Chiller", 1, 66)); // NOI18N
        labelO.setForeground(new java.awt.Color(255, 255, 255));
        labelO.setText("o");
        jPanel2.add(labelO);
        labelO.setBounds(360, 190, 40, 50);

        labelB.setBackground(new java.awt.Color(153, 153, 255));
        labelB.setFont(new java.awt.Font("Chiller", 1, 66)); // NOI18N
        labelB.setForeground(new java.awt.Color(255, 255, 255));
        labelB.setText("b");
        jPanel2.add(labelB);
        labelB.setBounds(300, 30, 40, 50);

        labelE.setBackground(new java.awt.Color(153, 153, 255));
        labelE.setFont(new java.awt.Font("Chiller", 1, 66)); // NOI18N
        labelE.setForeground(new java.awt.Color(255, 255, 255));
        labelE.setText("e");
        jPanel2.add(labelE);
        labelE.setBounds(240, 80, 40, 50);

        labelF.setBackground(new java.awt.Color(153, 153, 255));
        labelF.setFont(new java.awt.Font("Chiller", 1, 66)); // NOI18N
        labelF.setForeground(new java.awt.Color(255, 255, 255));
        labelF.setText("f");
        jPanel2.add(labelF);
        labelF.setBounds(300, 90, 40, 50);

        labelG.setBackground(new java.awt.Color(153, 153, 255));
        labelG.setFont(new java.awt.Font("Chiller", 1, 66)); // NOI18N
        labelG.setForeground(new java.awt.Color(255, 255, 255));
        labelG.setText("g");
        jPanel2.add(labelG);
        labelG.setBounds(360, 60, 40, 70);

        labelH.setBackground(new java.awt.Color(153, 153, 255));
        labelH.setFont(new java.awt.Font("Chiller", 1, 66)); // NOI18N
        labelH.setForeground(new java.awt.Color(255, 255, 255));
        labelH.setText("h");
        jPanel2.add(labelH);
        labelH.setBounds(410, 90, 40, 50);

        labelI.setBackground(new java.awt.Color(153, 153, 255));
        labelI.setFont(new java.awt.Font("Chiller", 1, 66)); // NOI18N
        labelI.setForeground(new java.awt.Color(255, 255, 255));
        labelI.setText("i");
        jPanel2.add(labelI);
        labelI.setBounds(240, 140, 40, 50);

        labelJ.setBackground(new java.awt.Color(153, 153, 255));
        labelJ.setFont(new java.awt.Font("Chiller", 1, 66)); // NOI18N
        labelJ.setForeground(new java.awt.Color(255, 255, 255));
        labelJ.setText("j");
        jPanel2.add(labelJ);
        labelJ.setBounds(300, 120, 30, 90);

        labelK.setBackground(new java.awt.Color(153, 153, 255));
        labelK.setFont(new java.awt.Font("Chiller", 1, 66)); // NOI18N
        labelK.setForeground(new java.awt.Color(255, 255, 255));
        labelK.setText("k");
        jPanel2.add(labelK);
        labelK.setBounds(360, 140, 40, 50);

        labelL.setBackground(new java.awt.Color(153, 153, 255));
        labelL.setFont(new java.awt.Font("Chiller", 1, 66)); // NOI18N
        labelL.setForeground(new java.awt.Color(255, 255, 255));
        labelL.setText("l");
        jPanel2.add(labelL);
        labelL.setBounds(420, 160, 40, 50);

        labelU.setBackground(new java.awt.Color(153, 153, 255));
        labelU.setFont(new java.awt.Font("Chiller", 1, 66)); // NOI18N
        labelU.setForeground(new java.awt.Color(255, 255, 255));
        labelU.setText("u");
        jPanel2.add(labelU);
        labelU.setBounds(420, 260, 40, 50);

        labelV.setBackground(new java.awt.Color(153, 153, 255));
        labelV.setFont(new java.awt.Font("Chiller", 1, 66)); // NOI18N
        labelV.setForeground(new java.awt.Color(255, 255, 255));
        labelV.setText("v");
        jPanel2.add(labelV);
        labelV.setBounds(240, 310, 40, 50);

        labelW.setBackground(new java.awt.Color(153, 153, 255));
        labelW.setFont(new java.awt.Font("Chiller", 1, 66)); // NOI18N
        labelW.setForeground(new java.awt.Color(255, 255, 255));
        labelW.setText("w");
        jPanel2.add(labelW);
        labelW.setBounds(280, 310, 40, 50);

        selectCategory.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        selectCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "hewan", "bunga", "buah" }));
        selectCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectCategoryActionPerformed(evt);
            }
        });
        jPanel2.add(selectCategory);
        selectCategory.setBounds(490, 400, 110, 30);

        jButton1.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jButton1.setText("New Word");
        jButton1.setIconTextGap(0);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(620, 400, 100, 30);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/titan.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(10, 360, 90, 90);

        score.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        score.setForeground(new java.awt.Color(255, 255, 255));
        score.setText("Score");
        jPanel2.add(score);
        score.setBounds(90, 230, 80, 20);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/helph.png"))); // NOI18N
        jButton3.setToolTipText("");
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(730, 400, 40, 33);

        mark.setFont(new java.awt.Font("Chiller", 0, 60)); // NOI18N
        mark.setForeground(new java.awt.Color(255, 255, 255));
        mark.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mark.setAlignmentX(0.5F);
        jPanel2.add(mark);
        mark.setBounds(470, 310, 310, 70);

        hangman10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hangman_10.png"))); // NOI18N
        hangman10.setText("jLabel14");
        jPanel2.add(hangman10);
        hangman10.setBounds(470, 30, 300, 270);

        hangman9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hangman_9.png"))); // NOI18N
        hangman9.setText("jLabel13");
        jPanel2.add(hangman9);
        hangman9.setBounds(470, 30, 300, 270);

        hangman8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hangman_8.png"))); // NOI18N
        hangman8.setText("jLabel12");
        jPanel2.add(hangman8);
        hangman8.setBounds(470, 30, 300, 270);

        hangman7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hangman_7.png"))); // NOI18N
        hangman7.setText("jLabel11");
        jPanel2.add(hangman7);
        hangman7.setBounds(470, 30, 300, 270);

        hangman6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hangman_6.png"))); // NOI18N
        hangman6.setText("jLabel10");
        jPanel2.add(hangman6);
        hangman6.setBounds(470, 30, 300, 270);

        hangman5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hangman_5.png"))); // NOI18N
        hangman5.setText("jLabel9");
        jPanel2.add(hangman5);
        hangman5.setBounds(470, 30, 300, 270);

        hangman4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hangman_4.png"))); // NOI18N
        hangman4.setText("jLabel8");
        jPanel2.add(hangman4);
        hangman4.setBounds(470, 30, 300, 270);

        hangman3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hangman_3.png"))); // NOI18N
        hangman3.setText("jLabel7");
        jPanel2.add(hangman3);
        hangman3.setBounds(470, 30, 300, 270);

        hangman2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hangman_2.png"))); // NOI18N
        hangman2.setText("jLabel6");
        jPanel2.add(hangman2);
        hangman2.setBounds(470, 30, 300, 270);

        hangman1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hangman_1.png"))); // NOI18N
        hangman1.setText("jLabel4");
        jPanel2.add(hangman1);
        hangman1.setBounds(470, 30, 300, 270);

        Background.setFont(new java.awt.Font("Chiller", 1, 60)); // NOI18N
        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/coba.PNG"))); // NOI18N
        Background.setText("a");
        jPanel2.add(Background);
        Background.setBounds(0, 0, 790, 449);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       newWord();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        form_utama t = new form_utama();
        game.getRuns();
        t.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        help e = new help();
        e.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void selectCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectCategoryActionPerformed
        
    }//GEN-LAST:event_selectCategoryActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(form_ketiga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_ketiga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_ketiga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_ketiga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_ketiga().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel hangman1;
    private javax.swing.JLabel hangman10;
    private javax.swing.JLabel hangman2;
    private javax.swing.JLabel hangman3;
    private javax.swing.JLabel hangman4;
    private javax.swing.JLabel hangman5;
    private javax.swing.JLabel hangman6;
    private javax.swing.JLabel hangman7;
    private javax.swing.JLabel hangman8;
    private javax.swing.JLabel hangman9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelA;
    private javax.swing.JLabel labelB;
    private javax.swing.JLabel labelC;
    private javax.swing.JLabel labelD;
    private javax.swing.JLabel labelE;
    private javax.swing.JLabel labelF;
    private javax.swing.JLabel labelG;
    private javax.swing.JLabel labelH;
    private javax.swing.JLabel labelI;
    private javax.swing.JLabel labelJ;
    private javax.swing.JLabel labelK;
    private javax.swing.JLabel labelL;
    private javax.swing.JLabel labelM;
    private javax.swing.JLabel labelN;
    private javax.swing.JLabel labelO;
    private javax.swing.JLabel labelP;
    private javax.swing.JLabel labelQ;
    private javax.swing.JLabel labelR;
    private javax.swing.JLabel labelS;
    private javax.swing.JLabel labelT;
    private javax.swing.JLabel labelU;
    private javax.swing.JLabel labelV;
    private javax.swing.JLabel labelW;
    private javax.swing.JLabel labelX;
    private javax.swing.JLabel labelY;
    private javax.swing.JLabel labelZ;
    private javax.swing.JLabel mark;
    private javax.swing.JLabel score;
    private javax.swing.JComboBox<String> selectCategory;
    private javax.swing.JLabel selectedName;
    // End of variables declaration//GEN-END:variables
}
