
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import javax.swing.JOptionPane;

public class Dashboard extends javax.swing.JFrame {

/**
 * Creates new form Dashboard
 */
public Dashboard() {
    initComponents();
    String name = Login.getUser_Name();
    lbl_name.setText(name.toUpperCase());
    int userid = Login.getUser_id();

    unitsConsumed(userid, name);
}
private StringBuilder key = new StringBuilder();

public void getUserInfo() {
    int userid = Login.getUser_id();
    try {
        Connection con = DbConn.getConnection();
        PreparedStatement pst = con.prepareStatement("select * from ebs.users where id=?");
        pst.setInt(1, userid);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            String name = rs.getString("name");
            String Meter = rs.getString("meterno");
            String Contact = rs.getString("Contact");
            JOptionPane.showMessageDialog(this, "Your Name:- " + name + "\nYour Meter No:- " + Meter + "\nYour Contact No:- " + Contact, "INFO", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

/**
 * ***********OriGinal CoDe*************************
 */
//public void unitsConsumed(int userId) {
//    int units;
//    LocalDate currentDate = LocalDate.now(); //get current date Format: YYYY-MM-DD
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//    try {
//        Connection conn = DbConn.getConnection();
//        PreparedStatement pst = conn.prepareStatement("select unit_consume from ebs.users where id=? and month_year=?");
//        pst.setInt(1, userId);
//        pst.setString(2, currentDate.toString());
//        ResultSet rs = pst.executeQuery();
//        if (rs.next()) { //this if checks if there is the logged in user have the data of unit consumed or not. if yes then it fetches the data and if not then it generates the units consumed
//            units = rs.getInt("unit_consume");
//        } else {
//            Random rand = new Random();//to set a random number on unit consumption label
//            units = rand.nextInt(201) + 100;
//            PreparedStatement ps = conn.prepareStatement("update  ebs.users set unit_consume=?,month_year=? where id=?");
//            ps.setInt(1, units);
//            ps.setString(2, currentDate.toString());
//            ps.setInt(3, userId);
//            ps.executeUpdate();
//        }
//        //to check if unit consume label is labelled or not if its not labelled then set the random generated value
//        if (lbl_unit_consum != null) {
//            lbl_unit_consum.setText(String.valueOf(units));
//        }
//        lbl_duedate.setText(currentDate.plusDays(3).format(formatter).toString());
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//
//}
public void unitsConsumed(int userId, String name) {
    int units;
    LocalDate currentDate = LocalDate.now(); //get current date Format: YYYY-MM-DD
    DateTimeFormatter currentDateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("yyyy-MM");
    DateTimeFormatter dueDateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String currentMonthYear = currentDate.format(monthYearFormatter); // Format: YYYY-MM
    try {
        Connection conn = DbConn.getConnection();
        PreparedStatement pst = conn.prepareStatement("SELECT unit_consume FROM ebs.consumption WHERE user_id = ? AND month_year = ? ");
        pst.setInt(1, userId);
        pst.setString(2, currentMonthYear);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) { //this if checks if there is the logged in user have the data of unit consumed or not. if yes then it fetches the data and if not then it generates the units consumed
            units = rs.getInt("unit_consume");
        } else {
            Random rand = new Random();//to set a random number on unit consumption label
            units = rand.nextInt(201) + 100;
            PreparedStatement ps = conn.prepareStatement("INSERT INTO ebs.consumption (user_id, month_year, unit_consume,name) VALUES (?, ?, ?,?)");
            ps.setInt(1, userId);
            ps.setString(2, currentMonthYear);
            ps.setInt(3, units);
            ps.setString(4, name);
            ps.executeUpdate();
        }
        //to check if unit consume label is labelled or not if its not labelled then set the random generated value
        if (lbl_unit_consum != null) {
            lbl_unit_consum.setText(String.valueOf(units));
        }
        lbl_conn.setText(currentDate.format(currentDateFormatter).toString());
        // Set due date to the 16th of the current month
        LocalDate dueDate = LocalDate.of(currentDate.getYear(), currentDate.getMonth(), 19);
        lbl_duedate.setText(dueDate.format(dueDateFormatter));
    } catch (Exception e) {
        e.printStackTrace();
    }

}

/**
 * This method is called from within the constructor to initialize the form.
 * WARNING: Do NOT modify this code. The content of this method is always
 * regenerated by the Form Editor.
 */
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_close = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbl_name = new javax.swing.JLabel();
        btn_info = new rojerusan.RSMaterialButtonCircle();
        btn_paybills = new rojerusan.RSMaterialButtonCircle();
        btn_viewbills = new rojerusan.RSMaterialButtonCircle();
        btn_logout = new rojerusan.RSMaterialButtonCircle();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbl_unit_consum = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_currentbill = new javax.swing.JLabel();
        lbl_duedate = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbl_conn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        btn_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/close_log.png"))); // NOI18N
        btn_close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_closeMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bill 50x60.png"))); // NOI18N
        jLabel1.setText("Electricity Billing System");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/male_user_50px.png"))); // NOI18N
        jLabel2.setText("WELCOME");

        lbl_name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_name.setForeground(new java.awt.Color(255, 255, 255));

        btn_info.setBackground(new java.awt.Color(51, 0, 204));
        btn_info.setText("VIEW INFO");
        btn_info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_infoActionPerformed(evt);
            }
        });

        btn_paybills.setBackground(new java.awt.Color(51, 0, 204));
        btn_paybills.setText("PAY BILLS");
        btn_paybills.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_paybillsActionPerformed(evt);
            }
        });

        btn_viewbills.setBackground(new java.awt.Color(51, 0, 204));
        btn_viewbills.setText("VIEW BILLS");
        btn_viewbills.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewbillsActionPerformed(evt);
            }
        });

        btn_logout.setBackground(new java.awt.Color(255, 51, 51));
        btn_logout.setText("LOGOUT");
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_name, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_info, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                    .addComponent(btn_paybills, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_viewbills, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lbl_name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btn_info, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_paybills, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_viewbills, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setPreferredSize(new java.awt.Dimension(214, 92));

        jPanel5.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/units 50x50.png"))); // NOI18N
        jLabel3.setText("jLabel3");

        lbl_unit_consum.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl_unit_consum.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_unit_consum, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(lbl_unit_consum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("UNITS CONSUMED");

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setPreferredSize(new java.awt.Dimension(214, 92));

        jPanel7.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/paid 50X50.png"))); // NOI18N
        jLabel8.setText("jLabel3");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("456");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("BILLS PAID");

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));

        jPanel9.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reward 50x50.png"))); // NOI18N
        jLabel11.setText("jLabel3");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("456");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("REWARD");

        jPanel10.setBackground(new java.awt.Color(204, 204, 204));

        jPanel11.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/penalty 50x50.png"))); // NOI18N
        jLabel14.setText("jLabel3");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("456");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("PENALTY");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("CURRENT BILL :-");

        lbl_currentbill.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_currentbill.setForeground(new java.awt.Color(0, 0, 0));
        lbl_currentbill.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_currentbill.setText("123123");

        lbl_duedate.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_duedate.setForeground(new java.awt.Color(0, 0, 0));
        lbl_duedate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("DUE DATE       :-");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("CONNECTION STARTED :-");

        lbl_conn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_conn.setForeground(new java.awt.Color(0, 0, 0));
        lbl_conn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(jLabel6))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                        .addGap(22, 22, 22)))))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_duedate, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_currentbill))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(jLabel10)
                                .addGap(192, 192, 192)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16)
                                .addGap(84, 84, 84))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel18)
                        .addGap(68, 68, 68)
                        .addComponent(lbl_conn, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 13, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(145, 145, 145)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_conn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_currentbill, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(lbl_duedate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 255, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(356, 356, 356)
                        .addComponent(btn_close, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(btn_close, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1411, 803));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_closeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMousePressed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_closeMousePressed

    private void btn_infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_infoActionPerformed
        // TODO add your handling code here:
        getUserInfo();
    }//GEN-LAST:event_btn_infoActionPerformed

    private void btn_paybillsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_paybillsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_paybillsActionPerformed

    private void btn_viewbillsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewbillsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_viewbillsActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        // TODO add your handling code here:
        Login log = new Login();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_logoutActionPerformed

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
        java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
        new Dashboard().setVisible(true);
    }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_close;
    private rojerusan.RSMaterialButtonCircle btn_info;
    private rojerusan.RSMaterialButtonCircle btn_logout;
    private rojerusan.RSMaterialButtonCircle btn_paybills;
    private rojerusan.RSMaterialButtonCircle btn_viewbills;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lbl_conn;
    private javax.swing.JLabel lbl_currentbill;
    private javax.swing.JLabel lbl_duedate;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_unit_consum;
    // End of variables declaration//GEN-END:variables
}
