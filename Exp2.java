import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.MenuSelectionManager;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.undo.UndoManager;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.GraphicsEnvironment;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

class WORD {
    private WORD() {
    }

    protected static final String[] files = { "Files   ", "文件(F) ", "檔案(F) " };
    protected static final String[] edit = { "Edit    ", "编辑(E) ", "編輯(E) " };
    protected static final String[] options = { "Options ", "选项(O) ", "選項(O) " };
    protected static final String[] help = { "Help    ", "帮助(H) ", "幫助(H) " };
    protected static final String[] copy = { "Copy", "复制", "複製" };
    protected static final String[] paste = { "Paste", "粘贴", "貼上" };
    protected static final String[] cut = { "Cut", "剪切", "剪下" };
    protected static final String[] delete = { "Delete", "删除", "刪除" };
    protected static final String[] select = { "Select all", "全选", "全選" };
    protected static final String[] undo = { "Undo", "撤销", "復原" };
    protected static final String[] redo = { "Redo", "恢复", "取消復原" };
    protected static final String[] scale = { "Scale", "缩放", "檢視" };
    protected static final String[] zin = { "Zoom in", "放大", "拉近顯示" };
    protected static final String[] zout = { "Zoom out", "缩小", "拉遠顯示" };
    protected static final String[] dft = { "Restore defaults", "恢复默认", "恢復預設" };
    protected static final String[] langu = { "Language", "语言", "語言" };
    protected static final String[] update = { "Check for updates", "检查更新", "檢查新版本" };
    protected static final String[] about = { "About", "关于", "關於" };
    protected static final String[] newf = { "New", "新建", "新增" };
    protected static final String[] open = { "Open", "打开", "打開" };
    protected static final String[] save = { "Save", "保存", "存儲檔案" };
    protected static final String[] saveas = { "Save as", "另存", "另存新檔" };
    protected static final String[] close = { "Close", "关闭", "關閉" };
    protected static final String[] exit = { "Exit", "退出", "離開" };
    protected static final String[] qsave = { "Save?", "保存？", "存儲？" };
    protected static final String[] setsize = { "Font Size", "字体大小", "調整字號" };
    protected static final String[] font = { "Font", "字体", "字體" };
    protected static final String[] back = { "Back", "返 回", "返 回" };
    protected static final String[] FIND = { "Find", "查找", "查找" };
    protected static final String[] FINDNEXT = { "Find Next", "查找下一个", "查找下一個" };
    protected static final String[] REPLACE = { "Replace", "替换", "替換" };
    protected static final String[] REPLACEALL = { "Replace All", "替换全部", "替換全部" };
    protected static final String[] CANCEL = { "Cancel", "取消", "取消" };
    protected static final String[] CNF = { "Could not find", "找不到", "找不到" };
    protected static final String[] nopen = { "No text file is open", "当前没有打开的文本文件", "當前沒有打開的文本文件" };
    protected static final String[] overnew = {
            "You have opened a text file. Do you want to save it before creating a new one?", "您已经打开了一个文本文档，是否在新建之前保存？",
            "您已經打開了一個文本檔案，是否在新增前存儲？" };
    protected static final String[] overopen = {
            "You have opened a text file. Do you want to save it before openning a new one?",
            "您已经打开了一个文本文档，是否在打开新文档之前保存？", "您已經打開了一個文本檔案，是否在打開新檔案前存儲？" };
    protected static final String[] exist = { "The file already exists. Overwrite it?", "文件已存在，是否覆盖？", "檔案已存在，是否覆蓋？" };
    protected static final String[] texist = { "File already exists", "文件已存在", "檔案已存在" };
    protected static final String[] cfail = { "File creation failed!", "文件创建失败！", "檔案創建失敗！" };
    protected static final String[] nofile = { "No such file!", "文件不存在！", "檔案不存在！" };
    protected static final String[] saveclose1 = { "Do You want to save ", "关闭前是否保存", "關閉前是否保存" };
    protected static final String[] saveclose2 = { " before closing?", "？", "？" };
    protected static final String[] saveexit1 = { "Do You want to save ", "退出前是否保存", "離開前是否保存" };
    protected static final String[] saveexit2 = { " before exiting?", "？", "？" };
    protected static final String[] title = { "CQU Text Editor", "重庆大学文本编辑器", "重慶大學文本編輯器" };
    protected static final String[] abtitle = { "About CQU Text Editor", "关于重庆大学文本编辑器", "關於重慶大學文本編輯器" };
    protected static final String[] abt = {
            "<html>CQU Text Editor<br>Version v1.1.0 Beta<br>WuMingyi 20194086<br>© 2020 Chongqing University    <br>All rights Reserved</html>",
            "<html>重庆大学文本编辑器<br>版本 v1.1.0 Beta<br>吴铭一 20194086<br>© 2020 重庆大学计算机学院    <br>保留所有权利</html>",
            "<html>重慶大學文本編輯器<br>版本 v1.1.0 Beta<br>吳銘一 20194086<br>© 2020 重慶大學計算機學院    <br>保留所有權利</html>" };
    protected static final String[] cupdate = { "Update", "检查更新", "更新應用程式" };
    protected static final String[] aupdate = { "It's already the latest version!", "已是最新版本", "當前已是最新版本" };
    protected static final String[][] LOADING = {
            { "The program is starting...", "Applying settings...", "The graphical interface is being drawn...",
                    "Nearly finished startup..." },
            { "正在启动...", "正在应用设置...", "正在绘制图形界面...", "即将完成..." },
            { "正在啓動...", "正在應用設定...", "正在繪製圖形界面...", "即將準備就緒..." } };
    protected static final String TFONT = "Microsoft YaHei";
    protected static final String ICON = "pic/CQUtext64.png";
}

class Find extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    int startIndex = 0;
    int selectStart = -1;
    int lang = 1;
    JLabel lab1;
    JLabel lab2;
    JTextField textF;
    JTextField textR;
    JButton findBtn;
    JButton findNext;
    JButton replace;
    JButton replaceAll;
    JButton cancel;
    private JTextArea txt;

    public Find(JTextArea text, int lang) {
        this.txt = text;
        this.lang = lang;
        this.setTitle(WORD.FIND[lang]);
        this.setIconImage(new ImageIcon(WORD.ICON).getImage());
        txt.requestFocus();
        lab1 = new JLabel(WORD.FIND[lang] + ":");
        lab2 = new JLabel(WORD.REPLACE[lang] + ":");
        textF = new JTextField(30);
        textR = new JTextField(30);
        findBtn = new JButton(WORD.FIND[lang]);
        findNext = new JButton(WORD.FINDNEXT[lang]);
        replace = new JButton(WORD.REPLACE[lang]);
        replaceAll = new JButton(WORD.REPLACEALL[lang]);
        cancel = new JButton(WORD.CANCEL[lang]);

        // Set Layout NULL
        setLayout(null);

        // Set the width and height of the label
        int labWidth = 80;
        int labHeight = 20;

        // Adding labels
        lab1.setBounds(10, 10, labWidth, labHeight);
        add(lab1);
        textF.setBounds(10 + labWidth, 10, 120, 20);
        add(textF);
        lab2.setBounds(10, 10 + labHeight + 10, labWidth, labHeight);
        add(lab2);
        textR.setBounds(10 + labWidth, 10 + labHeight + 10, 120, 20);
        add(textR);

        // Adding buttons
        findBtn.setBounds(225, 6, 115, 20);
        add(findBtn);
        findBtn.addActionListener(this);

        findNext.setBounds(225, 28, 115, 20);
        add(findNext);
        findNext.addActionListener(this);

        replace.setBounds(225, 50, 115, 20);
        add(replace);
        replace.addActionListener(this);

        replaceAll.setBounds(225, 72, 115, 20);
        add(replaceAll);
        replaceAll.addActionListener(this);

        cancel.setBounds(225, 94, 115, 20);
        add(cancel);
        cancel.addActionListener(this);

        // Set the width and height of the window
        int width = 360;
        int height = 160;

        // Set size window
        setSize(width, height);

        // center the frame on the frame
        setLocationRelativeTo(txt);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public void find() {
        selectStart = txt.getText().toLowerCase().indexOf(textF.getText().toLowerCase());
        if (selectStart == -1) {
            startIndex = 0;
            JOptionPane.showMessageDialog(null, WORD.CNF[lang] + " \"" + textF.getText() + "\"!");
            return;
        }
        if (selectStart == txt.getText().toLowerCase().lastIndexOf(textF.getText().toLowerCase())) {
            startIndex = 0;
        }
        int selectEnd = selectStart + textF.getText().length();
        txt.select(selectStart, selectEnd);
    }

    public void findNext() {
        String key = textF.getText();
        if (null == key || "".equals(key))
            return;
        int pos = txt.getSelectionStart() == txt.getSelectionEnd() ? txt.getSelectionStart()
                : txt.getSelectionStart() + 1;
        String content = txt.getText();
        int resultPos = content.indexOf(key, pos);
        if (-1 == resultPos && pos - key.length() >= 0)
            resultPos = content.substring(0, pos - key.length()).indexOf(key);
        if (-1 != resultPos) {
            txt.setSelectionStart(resultPos);
            txt.setSelectionEnd(resultPos + key.length());
        }
    }

    public void replace() {
        try {
            find();
            if (selectStart != -1)
                txt.replaceSelection(textR.getText());
        } catch (NullPointerException e) {
            System.out.print("Null Pointer Exception: " + e);
        }
    }

    public void replaceAll() {
        txt.setText(txt.getText().toLowerCase().replaceAll(textF.getText().toLowerCase(), textR.getText()));
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == findBtn) {
            find();
        } else if (e.getSource() == findNext) {
            findNext();
        } else if (e.getSource() == replace) {
            replace();
        } else if (e.getSource() == replaceAll) {
            replaceAll();
        } else if (e.getSource() == cancel) {
            this.setVisible(false);
            this.dispose();
        }
    }

}

class LodingPanel extends JPanel {
    private static final long serialVersionUID = 1551571546L;
    transient java.util.Timer timer;
    private int delay;
    private int startAngle = 0;
    private int arcAngle = 10;
    private int speed1 = 1;
    private int speed2 = 1;
    ImageIcon imgic = new ImageIcon("pic/CQU.png");
    Color co = new Color(244, 244, 244);
    Color cof = new Color(44, 44, 44);
    transient Image img = imgic.getImage();
    JFrame lframe = new JFrame();
    JLabel jlb = new JLabel("Loading...");

    public void showLoadingGUI() {
        lframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        lframe.setAlwaysOnTop(true);
        lframe.setUndecorated(true);
        lframe.setSize(400, 200);
        lframe.setLocationRelativeTo(null);
        lframe.setIconImage(img);
        JLabel label1 = new JLabel("CQU");
        JLabel label2 = new JLabel("Text");
        JLabel label3 = new JLabel("Editor");
        label1.setFont(new Font(WORD.TFONT, Font.BOLD, 60));
        label2.setFont(new Font(WORD.TFONT, Font.BOLD, 50));
        label3.setFont(new Font(WORD.TFONT, Font.BOLD, 50));
        label1.setForeground(cof);
        label2.setForeground(cof);
        label3.setForeground(cof);
        label1.setBounds(200, 15, 200, 60);
        label2.setBounds(205, 70, 200, 50);
        label3.setBounds(205, 120, 200, 50);
        jlb.setFont(new Font("Microsoft Yahei", Font.PLAIN, 12));
        jlb.setForeground(new Color(4, 16, 102));
        jlb.setBounds(200, 175, 190, 20);
        jlb.setHorizontalAlignment(SwingConstants.RIGHT);
        this.setBackground(co);
        this.add(label1);
        this.add(label2);
        this.add(label3);
        this.add(jlb);
        lframe.add(this);
        lframe.setVisible(true);
    }

    public LodingPanel() {
        this.delay = 5;
        this.setLayout(null);
        init();
    }

    public void stopl() {
        this.timer.cancel();
    }

    private void init() {
        timer = new java.util.Timer(true);
        timer.schedule(new java.util.TimerTask() {
            public void run() {
                if (startAngle < 360) {
                    startAngle += speed1;
                } else {
                    startAngle = 0;
                }
                if (arcAngle < 350 && arcAngle > 10) {
                    arcAngle += speed2;
                } else if (arcAngle >= 350) {
                    speed1 = 2;
                    speed2 = -1;
                    arcAngle += speed2;
                } else {
                    speed1 = 1;
                    speed2 = 1;
                    arcAngle += speed2;
                }
                repaint();
            }
        }, 0, delay);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawArc(g);
        g.drawImage(img, 30, 30, 140, 140, null);
    }

    private void drawArc(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        // Anti-aliasing
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Pen Color
        g2d.setColor(co);
        g2d.drawArc(20, 20, 160, 160, 0, 360);
        g2d.setColor(Color.BLUE);
        g2d.fillArc(20, 20, 160, 160, startAngle, arcAngle);
        g2d.setColor(Color.WHITE);
        g2d.fillArc(32, 32, 136, 136, 0, 360);
        g2d.dispose();
    }
}

class AboutFrame extends JPanel {
    private static final long serialVersionUID = 1L;
    JFrame af = new JFrame();
    ImageIcon imgic = new ImageIcon("pic/CQUtext1024.png");
    JLabel lb = new JLabel();
    JButton jbt = new JButton();
    transient Image img = imgic.getImage();

    AboutFrame(int lang) {
        this.setLayout(null);
        jbt.setText(WORD.back[lang]);
        jbt.setBounds(360, 185, 100, 30);
        jbt.addActionListener(e -> af.setVisible(false));
        lb.setFont(new Font(WORD.TFONT, Font.PLAIN, 14));
        lb.setBounds(250, 30, 230, 150);
        af.setIconImage(new ImageIcon(WORD.ICON).getImage());
        af.setTitle(WORD.abtitle[lang]);
        af.setAlwaysOnTop(true);
        af.setSize(480, 260);
        af.setResizable(false);
        af.setLocationRelativeTo(null);
        af.getContentPane().add(lb);
        af.getContentPane().add(jbt);
        af.add(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 50, 30, 150, 150, null);
    }

    public void showaf(int lang) {
        af.setTitle(WORD.abtitle[lang]);
        jbt.setText(WORD.back[lang]);
        lb.setText(WORD.abt[lang]);
        af.setVisible(true);
    }
}

// 这个类来自Google搜索，用于实现滚动菜单
class MenuScroller {
    private JPopupMenu menu;
    private Component[] menuItems;
    private MenuScrollItem upItem;
    private MenuScrollItem downItem;
    private final MenuScrollListener menuListener = new MenuScrollListener();
    private int scrollCount;
    private int interval;
    private int topFixedCount;
    private int bottomFixedCount;
    private int firstIndex = 0;
    private int keepVisibleIndex = -1;

    private class MenuScrollItem extends JMenuItem implements ChangeListener {
        private static final long serialVersionUID = 1L;
        private MenuScrollTimer timer;

        public MenuScrollItem(MenuIcon icon, int increment) {
            setIcon(icon);
            setDisabledIcon(icon);
            timer = new MenuScrollTimer(increment, interval);
            addChangeListener(this);
        }

        public void setInterval(int interval) {
            timer.setDelay(interval);
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            if (isArmed() && !timer.isRunning())
                timer.start();
            if (!isArmed() && timer.isRunning())
                timer.stop();
        }
    }

    private void refreshMenu() {
        if (menuItems != null && menuItems.length > 0) {
            firstIndex = Math.max(topFixedCount, firstIndex);
            firstIndex = Math.min(menuItems.length - bottomFixedCount - scrollCount, firstIndex);
            upItem.setEnabled(firstIndex > topFixedCount);
            downItem.setEnabled(firstIndex + scrollCount < menuItems.length - bottomFixedCount);
            menu.removeAll();
            for (int i = 0; i < topFixedCount; i++)
                menu.add(menuItems[i]);
            if (topFixedCount > 0)
                menu.addSeparator();
            menu.add(upItem);
            for (int i = firstIndex; i < scrollCount + firstIndex; i++)
                menu.add(menuItems[i]);
            menu.add(downItem);
            if (bottomFixedCount > 0)
                menu.addSeparator();
            for (int i = menuItems.length - bottomFixedCount; i < menuItems.length; i++)
                menu.add(menuItems[i]);
            JComponent parent = (JComponent) upItem.getParent();
            parent.revalidate();
            parent.repaint();
        }
    }

    private class MenuScrollListener implements PopupMenuListener {
        @Override
        public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
            setMenuItems();
        }

        @Override
        public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
            restoreMenuItems();
        }

        @Override
        public void popupMenuCanceled(PopupMenuEvent e) {
            restoreMenuItems();
        }

        private void setMenuItems() {
            menuItems = menu.getComponents();
            if (keepVisibleIndex >= topFixedCount && keepVisibleIndex <= menuItems.length - bottomFixedCount
                    && (keepVisibleIndex > firstIndex + scrollCount || keepVisibleIndex < firstIndex)) {
                firstIndex = Math.min(firstIndex, keepVisibleIndex);
                firstIndex = Math.max(firstIndex, keepVisibleIndex - scrollCount + 1);
            }
            if (menuItems.length > topFixedCount + scrollCount + bottomFixedCount) {
                refreshMenu();
            }
        }

        private void restoreMenuItems() {
            menu.removeAll();
            for (Component component : menuItems) {
                menu.add(component);
            }
        }
    }

    private enum MenuIcon implements Icon {
        UP(9, 1, 9), DOWN(1, 9, 1);

        final int[] xPoints = { 1, 5, 9 };
        final int[] yPoints;

        MenuIcon(int... yPoints) {
            this.yPoints = yPoints;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            Dimension size = c.getSize();
            Graphics g2 = g.create(size.width / 2 - 5, size.height / 2 - 5, 10, 10);
            g2.setColor(Color.GRAY);
            g2.drawPolygon(xPoints, yPoints, 3);
            if (c.isEnabled()) {
                g2.setColor(Color.BLACK);
                g2.fillPolygon(xPoints, yPoints, 3);
            }
            g2.dispose();
        }

        @Override
        public int getIconWidth() {
            return 0;
        }

        @Override
        public int getIconHeight() {
            return 10;
        }
    }

    private class MenuScrollTimer extends Timer {
        private static final long serialVersionUID = 1L;

        public MenuScrollTimer(final int increment, int interval) {
            super(interval, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    firstIndex += increment;
                    refreshMenu();
                }
            });
        }
    }

    public MenuScroller(JMenu menu, int scrollCount, int interval, int topFixedCount, int bottomFixedCount) {
        this(menu.getPopupMenu(), scrollCount, interval, topFixedCount, bottomFixedCount);
    }

    public void setScrollCount(int scrollCount) {
        if (scrollCount <= 0) {
            throw new IllegalArgumentException("scrollCount must be greater than 0");
        }
        this.scrollCount = scrollCount;
        MenuSelectionManager.defaultManager().clearSelectedPath();
    }

    public void setInterval(int interval) {
        if (interval <= 0) {
            throw new IllegalArgumentException("interval must be greater than 0");
        }
        upItem.setInterval(interval);
        downItem.setInterval(interval);
        this.interval = interval;
    }

    public void setTopFixedCount(int topFixedCount) {
        if (firstIndex <= topFixedCount) {
            firstIndex = topFixedCount;
        } else {
            firstIndex += (topFixedCount - this.topFixedCount);
        }
        this.topFixedCount = topFixedCount;
    }

    public void setBottomFixedCount(int bottomFixedCount) {
        this.bottomFixedCount = bottomFixedCount;
    }

    public MenuScroller(JPopupMenu menu, int scrollCount, int interval, int topFixedCount, int bottomFixedCount) {
        if (scrollCount <= 0 || interval <= 0) {
            throw new IllegalArgumentException("scrollCount and interval must be greater than 0");
        }
        if (topFixedCount < 0 || bottomFixedCount < 0) {
            throw new IllegalArgumentException("topFixedCount and bottomFixedCount cannot be negative");
        }
        upItem = new MenuScrollItem(MenuIcon.UP, -1);
        downItem = new MenuScrollItem(MenuIcon.DOWN, +1);
        setScrollCount(scrollCount);
        setInterval(interval);
        setTopFixedCount(topFixedCount);
        setBottomFixedCount(bottomFixedCount);
        this.menu = menu;
        menu.addPopupMenuListener(menuListener);
    }
}

class TextFileFilter extends FileFilter {
    String ends;
    String description;

    public TextFileFilter(String ends, String description) {
        this.ends = ends;
        this.description = description;
    }

    public String getEnds() {
        return this.ends;
    }

    public String getDescription() {
        return description;
    }

    public boolean accept(File file) {
        return file.isDirectory() || file.getName().toLowerCase().endsWith(ends);
    }
}

class TextAreaMenu extends JTextArea implements MouseListener {
    private static final long serialVersionUID = -5942087991012920147L;
    private int lang = 0;
    private JPopupMenu pop = new JPopupMenu();
    private JMenu mscale = new JMenu();
    private JMenuItem copy = new JMenuItem();
    private JMenuItem paste = new JMenuItem();
    private JMenuItem cut = new JMenuItem();
    private JMenuItem delete = new JMenuItem();
    private JMenuItem checkAll = new JMenuItem();
    private JMenuItem undo = new JMenuItem();
    private JMenuItem redo = new JMenuItem();
    private JMenuItem zoin = new JMenuItem();
    private JMenuItem zoout = new JMenuItem();
    private JMenuItem zodft = new JMenuItem();
    private UndoManager um = new UndoManager();
    Exp2 mex = null;

    public void setMenuText(int lang) {
        mscale.setText(WORD.scale[lang]);
        copy.setText(WORD.copy[lang]);
        paste.setText(WORD.paste[lang]);
        cut.setText(WORD.cut[lang]);
        delete.setText(WORD.delete[lang]);
        checkAll.setText(WORD.select[lang]);
        undo.setText(WORD.undo[lang]);
        redo.setText(WORD.redo[lang]);
        zoin.setText(WORD.zin[lang]);
        zoout.setText(WORD.zout[lang]);
        zodft.setText(WORD.dft[lang]);
    }

    public TextAreaMenu() {
        super();
        init();
    }

    public TextAreaMenu(String str) {
        super(str);
        init();
    }

    public TextAreaMenu(int lang, Exp2 mex) {
        super();
        this.lang = lang;
        this.mex = mex;
        init();
    }

    private void init() {
        this.addMouseListener(this);
        this.getDocument().addUndoableEditListener(um);
        setMenuText(lang);
        pop.add(copy);
        pop.add(paste);
        pop.add(cut);
        pop.add(delete);
        pop.addSeparator();
        pop.add(checkAll);
        pop.addSeparator();
        pop.add(undo);
        pop.add(redo);
        pop.addSeparator();
        pop.add(mscale);
        mscale.add(zoin);
        mscale.add(zoout);
        mscale.add(zodft);
        copy.setIcon(new ImageIcon("pic/copy_b.png"));
        paste.setIcon(new ImageIcon("pic/paste_b.png"));
        cut.setIcon(new ImageIcon("pic/cut_b.png"));
        undo.setIcon(new ImageIcon("pic/undo_b.png"));
        redo.setIcon(new ImageIcon("pic/redo_b.png"));
        checkAll.setIcon(new ImageIcon("pic/select_all_b.png"));
        delete.setIcon(new ImageIcon("pic/delete.png"));
        mscale.setIcon(new ImageIcon("pic/size.png"));
        zoin.setIcon(new ImageIcon("pic/zoom_in.png"));
        zoout.setIcon(new ImageIcon("pic/zoom_out.png"));
        copy.addActionListener(this::action);
        paste.addActionListener(this::action);
        cut.addActionListener(this::action);
        delete.addActionListener(this::action);
        checkAll.addActionListener(this::action);
        undo.addActionListener(this::action);
        redo.addActionListener(this::action);
        zoin.addActionListener(this::action);
        zoout.addActionListener(this::action);
        zodft.addActionListener(this::action);
        this.add(pop);
    }

    public void txtundo() {
        um.undo();
    }

    public void txtredo() {
        um.redo();
    }

    private void action(ActionEvent e) {
        String str = e.getActionCommand();
        if (str.equals(copy.getText())) {
            this.copy();
        } else if (str.equals(paste.getText())) {
            this.paste();
        } else if (str.equals(cut.getText())) {
            this.cut();
        } else if (str.equals(delete.getText())) {
            this.replaceSelection("");
        } else if (str.equals(checkAll.getText())) {
            this.selectAll();
        } else if (str.equals(undo.getText()) && um.canUndo()) {
            um.undo();
        } else if (str.equals(redo.getText()) && um.canRedo()) {
            um.redo();
        } else if (str.equals(zoin.getText())) {
            mex.sizechange(2);
        } else if (str.equals(zoout.getText())) {
            mex.sizechange(-2);
        } else if (str.equals(zodft.getText())) {
            mex.sizechange(0);
        }
    }

    public JPopupMenu getPop() {
        return pop;
    }

    public void setPop(JPopupMenu pop) {
        this.pop = pop;
    }

    public boolean isClipboardString() {
        boolean b = false;
        Clipboard clipboard = this.getToolkit().getSystemClipboard();
        Transferable content = clipboard.getContents(this);
        try {
            if (content.getTransferData(DataFlavor.stringFlavor) instanceof String) {
                b = true;
            }
        } catch (Exception e) {
            // Nothing
        }
        return b;
    }

    public boolean isCanCopy() {
        boolean b = false;
        int start = this.getSelectionStart();
        int end = this.getSelectionEnd();
        if (start != end)
            b = true;
        return b;
    }

    public boolean umcu() {
        return um.canUndo();
    }

    public boolean umcr() {
        return um.canRedo();
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            copy.setEnabled(isCanCopy() && this.isEnabled());
            paste.setEnabled(isClipboardString() && this.isEnabled());
            cut.setEnabled(isCanCopy() && this.isEnabled());
            delete.setEnabled(isCanCopy() && this.isEnabled());
            undo.setEnabled(um.canUndo() && this.isEnabled());
            redo.setEnabled(um.canRedo() && this.isEnabled());
            checkAll.setEnabled(this.isEnabled());
            zoin.setEnabled(mex.tsize <= 98);
            zoout.setEnabled(mex.tsize >= 12);
            pop.show(this, e.getX(), e.getY());
        }
    }

    public void mouseEntered(MouseEvent e) {
        // Nothing
    }

    public void mouseExited(MouseEvent e) {
        // Nothing
    }

    public void mousePressed(MouseEvent e) {
        // Nothing
    }

    public void mouseReleased(MouseEvent e) {
        // Nothing
    }
}

public class Exp2 extends JFrame {
    private static final long serialVersionUID = 1L;
    boolean opened = false;
    File f = null;
    Color txtco = new Color(200, 200, 200);
    Color txtco2 = new Color(250, 250, 250);
    int tsize = 18;
    int lang = 1;
    String fnt = WORD.TFONT;
    LodingPanel lp = null;
    JFrame frame = new JFrame(WORD.title[lang]);
    JFrame popout = null;
    TextAreaMenu txt = new TextAreaMenu(lang, this);
    JLabel label = new JLabel(WORD.nopen[this.lang]);
    JLabel label2 = new JLabel();
    JPanel jp = null;
    JScrollPane jsp = null;
    JSlider jsl = null;
    AboutFrame abf = null;
    Font fo1 = new Font(WORD.TFONT, Font.BOLD, 20);
    Font fo2 = new Font(WORD.TFONT, Font.PLAIN, 12);
    Font fo3 = new Font(WORD.TFONT, Font.BOLD, 16);
    JButton btn = new JButton(" " + WORD.newf[this.lang]);
    JButton bto = new JButton(" " + WORD.open[this.lang]);
    JButton bts = new JButton(" " + WORD.save[this.lang]);
    JButton btsa = new JButton(" " + WORD.saveas[this.lang]);
    JButton btc = new JButton(" " + WORD.close[this.lang]);
    JButton bte = new JButton(" " + WORD.exit[this.lang]);
    JButton[] sbt = { null, null, null, null, null, null };
    transient JFileChooser jfc = null;
    transient TextFileFilter ttff = null;
    transient TextFileFilter ctff = null;
    transient TextFileFilter cpptff = null;
    transient TextFileFilter htff = null;
    transient TextFileFilter javatff = null;
    transient TextFileFilter pytff = null;
    transient TextFileFilter pascaltff = null;
    transient TextFileFilter initff = null;
    transient TextFileFilter dlltff = null;
    transient TextFileFilter lrctff = null;
    transient TextFileFilter nonetff = null;

    // Menu
    JMenuBar jmb = null;
    JMenu jmfiles = null;
    JMenu jmedit = null;
    JMenu jmset = null;
    JMenu jmlan = null;
    JMenu jmscale = null;
    JMenu jmfont = null;
    JMenu jmhelp = null;
    JMenuItem jminew = null;
    JMenuItem jmiopen = null;
    JMenuItem jmisave = null;
    JMenuItem jmisaveas = null;
    JMenuItem jmiclose = null;
    JMenuItem jmiexit = null;
    JMenuItem copy = null;
    JMenuItem paste = null;
    JMenuItem cut = null;
    JMenuItem delete = null;
    JMenuItem checkAll = null;
    JMenuItem undo = null;
    JMenuItem redo = null;
    JMenuItem find = null;
    JMenuItem mch = null;
    JMenuItem mft = null;
    JMenuItem men = null;
    JMenuItem zin = null;
    JMenuItem zout = null;
    JMenuItem zdft = null;
    JMenuItem update = null;
    JMenuItem about = null;
    JMenuItem dfnt = null;

    public Exp2(LodingPanel lp) {
        this.lp = lp;
    }

    class NewItem extends SwingWorker<Void, Void> {
        private void setkey() {
            jminew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
            jmiopen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
            jmisave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
            copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
            paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
            cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
            checkAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
            undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK));
            redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_DOWN_MASK));
            zin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ADD, InputEvent.CTRL_DOWN_MASK));
            zout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, InputEvent.CTRL_DOWN_MASK));
            find.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK));
            jmfiles.setMnemonic(KeyEvent.VK_F);
            jmedit.setMnemonic(KeyEvent.VK_E);
            jmset.setMnemonic(KeyEvent.VK_O);
            jmhelp.setMnemonic(KeyEvent.VK_H);
        }

        private void setsbt(JButton bt, String r, int x, int y) {
            bt.setBounds(x, y, 30, 30);
            bt.setBackground(Color.GRAY);
            bt.setIcon(new ImageIcon("pic/" + r + "_w.png"));
            bt.setPressedIcon(new ImageIcon("pic/" + r + "_b.png"));
            bt.setBorderPainted(false);
            bt.setFocusPainted(false);
            frame.getContentPane().add(bt);
            bt.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent e) {
                    bt.setBackground(Color.GRAY);
                    label2.setText("");
                }
            });
        }

        private void setbt(JButton bt, String r, int h, Color co) {
            bt.setFont(fo1);
            bt.setBounds(620, h, 150, 50);
            bt.setBackground(Color.GRAY);
            bt.setIcon(new ImageIcon("pic/" + r + "_w.png"));
            bt.setPressedIcon(new ImageIcon("pic/" + r + "_b.png"));
            bt.setBorderPainted(false);
            bt.setFocusPainted(false);
            bt.setHorizontalAlignment(SwingConstants.LEFT);
            frame.getContentPane().add(bt);
            bt.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    bt.setBackground(co);
                }
            });
            bt.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent e) {
                    bt.setBackground(Color.GRAY);
                }
            });
        }

        private void btact() {
            sbt[0].addActionListener(e -> {
                if (txt.isCanCopy() && opened)
                    txt.copy();
            });
            sbt[1].addActionListener(e -> {
                if (txt.isClipboardString() && opened)
                    txt.paste();
            });
            sbt[2].addActionListener(e -> {
                if (txt.isCanCopy() && opened)
                    txt.cut();
            });
            sbt[3].addActionListener(e -> {
                txt.requestFocus();
                if (opened)
                    txt.selectAll();
            });
            sbt[4].addActionListener(e -> {
                if (txt.umcu() && opened)
                    txt.txtundo();
            });
            sbt[5].addActionListener(e -> {
                if (txt.umcr() && opened)
                    txt.txtredo();
            });
        }

        private void setframe() {
            frame.setIconImage(new ImageIcon(WORD.ICON).getImage());
            frame.getContentPane().setLayout(null);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setUndecorated(false);
            frame.setSize(800, 600);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.getContentPane().setBackground(new Color(45, 44, 50));
            label.setFont(new Font(WORD.TFONT, Font.PLAIN, 15));
            label.setForeground(Color.LIGHT_GRAY);
            label.setBounds(15, 510, 770, 25);
            label2.setBounds(700, 380, 70, 30);
            label2.setForeground(Color.LIGHT_GRAY);
            label2.setFont(new Font(WORD.TFONT, Font.PLAIN, 15));
            label2.setHorizontalAlignment(SwingConstants.CENTER);
            frame.getContentPane().add(label2);
            frame.getContentPane().add(label);
            for (int i = 0; i < 6; i++) {
                sbt[i] = new JButton();
            }
            setbt(btn, "new", 15, Color.LIGHT_GRAY); // Button New
            setbt(bto, "open", 80, Color.LIGHT_GRAY); // Button Open
            setbt(bts, "save", 145, Color.LIGHT_GRAY); // Button Save
            setbt(btsa, "save_as", 210, Color.LIGHT_GRAY); // Button SaveAs
            setbt(btc, "close", 275, Color.LIGHT_GRAY); // Button Close
            setbt(bte, "exit", 455, Color.RED); // Button2
            setsbt(sbt[0], "copy", 620, 340);
            setsbt(sbt[1], "paste", 660, 340);
            setsbt(sbt[2], "cut", 700, 340);
            setsbt(sbt[3], "select_all", 740, 340);
            setsbt(sbt[4], "undo", 620, 380);
            setsbt(sbt[5], "redo", 660, 380);
            btn.addActionListener(event -> btnew());
            bto.addActionListener(event -> btopen());
            bts.addActionListener(event -> btsave());
            btsa.addActionListener(event -> btsaveas());
            btc.addActionListener(event -> btclose());
            bte.addActionListener(event -> btexit());
            btact();
            txt.setLineWrap(true);
            txt.setBackground(txtco);
            txt.setForeground(new Color(4, 16, 102));
            txt.setSelectionColor(new Color(175, 212, 255));
            txt.setSelectedTextColor(new Color(36, 120, 146));
            txt.setFont(new Font(fnt, Font.PLAIN, tsize));
            txt.setEnabled(false);
            jsl = new JSlider(10, 100, 18);
            jsl.setBounds(620, 420, 150, 30);
            jsl.setBackground(null);
            jsl.setOpaque(true);
            jsl.addChangeListener(e -> setsize(jsl.getValue()));
            jsl.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    label2.setText(WORD.setsize[lang]);
                }
            });
            jsl.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent e) {
                    label2.setText("");
                    txt.requestFocus();
                }
            });
            sbt[0].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    sbt[0].setBackground(Color.LIGHT_GRAY);
                    label2.setText(WORD.copy[lang]);
                }
            });
            sbt[1].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    sbt[1].setBackground(Color.LIGHT_GRAY);
                    label2.setText(WORD.paste[lang]);
                }
            });
            sbt[2].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    sbt[2].setBackground(Color.LIGHT_GRAY);
                    label2.setText(WORD.cut[lang]);
                }
            });
            sbt[3].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    sbt[3].setBackground(Color.LIGHT_GRAY);
                    label2.setText(WORD.select[lang]);
                }
            });
            sbt[4].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    sbt[4].setBackground(Color.LIGHT_GRAY);
                    label2.setText(WORD.undo[lang]);
                }
            });
            sbt[5].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    sbt[5].setBackground(Color.LIGHT_GRAY);
                    label2.setText(WORD.redo[lang]);
                }
            });
            jp = new JPanel();
            jp.setLayout(null);
            jsp = new JScrollPane(txt);
            jsp.setBounds(0, 0, 590, 490);
            jsp.setBorder(BorderFactory.createEmptyBorder());
            jp.add(jsp);
            jp.setBounds(15, 15, 590, 490);
            frame.add(jp);
            frame.add(jsl);
        }

        private void addfont() {
            GraphicsEnvironment en = GraphicsEnvironment.getLocalGraphicsEnvironment();
            String[] fontNames = en.getAvailableFontFamilyNames();
            dfnt = new JMenuItem(WORD.dft[lang]);
            dfnt.addActionListener(e -> {
                fnt = WORD.TFONT;
                txt.setFont(new Font(fnt, Font.PLAIN, tsize));
            });
            jmfont.add(dfnt);
            new MenuScroller(jmfont, 20, 30, 1, 0);
            for (String fontName : fontNames) {
                JMenuItem nf = new JMenuItem(fontName);
                nf.addActionListener(e -> {
                    fnt = nf.getText();
                    txt.setFont(new Font(fnt, Font.PLAIN, tsize));
                });
                jmfont.add(nf);
            }
        }

        private void initable() {
            btn.setEnabled(true);
            bto.setEnabled(true);
            bts.setEnabled(true);
            btsa.setEnabled(true);
            btc.setEnabled(true);
            bte.setEnabled(true);
            jmb.setEnabled(true);
        }

        @Override
        // 后台任务在此方法中实现
        protected Void doInBackground() throws Exception {
            lp.jlb.setText(WORD.LOADING[lang][0]);
            newMenu();
            jfc = new JFileChooser(new File("."));
            lp.jlb.setText(WORD.LOADING[lang][1]);
            newtff();
            setkey();
            setframe();
            Thread.sleep(300);
            lp.jlb.setText(WORD.LOADING[lang][2]);
            popout = new JFrame(WORD.cupdate[lang]);
            abf = new AboutFrame(lang);
            Thread.sleep(400);
            lp.jlb.setText(WORD.LOADING[lang][3]);
            addfont();
            setable();
            Thread.sleep(200);
            return null;
        }

        @Override
        // 任务完成后返回一个信息
        protected void done() {
            lp.stopl();
            frame.setVisible(true);
            lp.lframe.setVisible(false);
            lp.lframe.dispose();
            initable();
        }
    }

    public void newMenu() {
        jmb = new JMenuBar();
        jmb.setEnabled(false);
        jmfiles = new JMenu(WORD.files[this.lang]);
        jmedit = new JMenu(WORD.edit[this.lang]);
        jmset = new JMenu(WORD.options[this.lang]);
        jmlan = new JMenu(WORD.langu[this.lang]);
        jmscale = new JMenu(WORD.scale[this.lang]);
        jmfont = new JMenu(WORD.font[lang]);
        jmhelp = new JMenu(WORD.help[this.lang]);
        jminew = new JMenuItem(WORD.newf[this.lang]);
        jmiopen = new JMenuItem(WORD.open[this.lang]);
        jmisave = new JMenuItem(WORD.save[this.lang]);
        jmisaveas = new JMenuItem(WORD.saveas[this.lang]);
        jmiclose = new JMenuItem(WORD.close[this.lang]);
        jmiexit = new JMenuItem(WORD.exit[this.lang]);
        copy = new JMenuItem(WORD.copy[this.lang]);
        paste = new JMenuItem(WORD.paste[this.lang]);
        cut = new JMenuItem(WORD.cut[this.lang]);
        delete = new JMenuItem(WORD.delete[this.lang]);
        checkAll = new JMenuItem(WORD.select[this.lang]);
        undo = new JMenuItem(WORD.undo[this.lang]);
        redo = new JMenuItem(WORD.redo[this.lang]);
        mch = new JMenuItem("简体中文");
        mft = new JMenuItem("繁體中文");
        men = new JMenuItem("English");
        find = new JMenuItem(WORD.FIND[lang]);
        zin = new JMenuItem(WORD.zin[this.lang]);
        zout = new JMenuItem(WORD.zout[this.lang]);
        zdft = new JMenuItem(WORD.dft[this.lang]);
        update = new JMenuItem(WORD.update[this.lang]);
        about = new JMenuItem(WORD.about[this.lang]);
        jmfiles.setFont(fo2);
        jmedit.setFont(fo2);
        jmset.setFont(fo2);
        jmhelp.setFont(fo2);
        // Create Window
        jminew.setIcon(new ImageIcon("pic/new.png"));
        jmiopen.setIcon(new ImageIcon("pic/open.png"));
        jmisave.setIcon(new ImageIcon("pic/save.png"));
        jmisaveas.setIcon(new ImageIcon("pic/save_as.png"));
        jmiclose.setIcon(new ImageIcon("pic/close.png"));
        jmiexit.setIcon(new ImageIcon("pic/exit.png"));
        copy.setIcon(new ImageIcon("pic/copy_b.png"));
        paste.setIcon(new ImageIcon("pic/paste_b.png"));
        cut.setIcon(new ImageIcon("pic/cut_b.png"));
        undo.setIcon(new ImageIcon("pic/undo_b.png"));
        redo.setIcon(new ImageIcon("pic/redo_b.png"));
        checkAll.setIcon(new ImageIcon("pic/select_all_b.png"));
        delete.setIcon(new ImageIcon("pic/delete.png"));
        jmscale.setIcon(new ImageIcon("pic/size.png"));
        zin.setIcon(new ImageIcon("pic/zoom_in.png"));
        zout.setIcon(new ImageIcon("pic/zoom_out.png"));
        jmlan.setIcon(new ImageIcon("pic/language.png"));
        jmfont.setIcon(new ImageIcon("pic/font.png"));
        update.setIcon(new ImageIcon("pic/update.png"));
        jmfiles.add(jminew);
        jmfiles.add(jmiopen);
        jmfiles.add(jmisave);
        jmfiles.add(jmisaveas);
        jmfiles.add(jmiclose);
        jmfiles.addSeparator();
        jmfiles.add(jmiexit);
        jmedit.add(copy);
        jmedit.add(paste);
        jmedit.add(cut);
        jmedit.add(delete);
        jmedit.addSeparator();
        jmedit.add(checkAll);
        jmedit.addSeparator();
        jmedit.add(undo);
        jmedit.add(redo);
        jmedit.addSeparator();
        jmedit.add(find);
        jmscale.add(zin);
        jmscale.add(zout);
        jmscale.add(zdft);
        jmlan.add(mch);
        jmlan.add(mft);
        jmlan.add(men);
        jmset.add(jmscale);
        jmset.addSeparator();
        jmset.add(jmfont);
        jmset.addSeparator();
        jmset.add(jmlan);
        jmhelp.add(update);
        jmhelp.add(about);
        jmb.add(jmfiles);
        jmb.add(jmedit);
        jmb.add(jmset);
        jmb.add(jmhelp);
        frame.setJMenuBar(jmb);
        jminew.addActionListener(e -> btnew());
        jmiopen.addActionListener(e -> btopen());
        jmisave.addActionListener(e -> btsave());
        jmisaveas.addActionListener(e -> btsaveas());
        jmiclose.addActionListener(e -> btclose());
        jmiexit.addActionListener(e -> btexit());
        // Menu
        copy.addActionListener(this::action);
        paste.addActionListener(this::action);
        cut.addActionListener(this::action);
        delete.addActionListener(this::action);
        checkAll.addActionListener(this::action);
        undo.addActionListener(this::action);
        redo.addActionListener(this::action);
        find.addActionListener(e -> new Find(txt, lang));
        zin.addActionListener(e -> {
            sizechange(2);
            zin.setEnabled(tsize <= 98);
            zout.setEnabled(tsize >= 12);
        });
        zout.addActionListener(e -> {
            sizechange(-2);
            zin.setEnabled(tsize <= 98);
            zout.setEnabled(tsize >= 12);
        });
        zdft.addActionListener(e -> {
            sizechange(0);
            zin.setEnabled(tsize <= 98);
            zout.setEnabled(tsize >= 12);
        });
        mch.addActionListener(e -> {
            lang = 1;
            changeLanguage();
        });
        mft.addActionListener(e -> {
            lang = 2;
            changeLanguage();
        });
        men.addActionListener(e -> {
            lang = 0;
            changeLanguage();
        });
        update.addActionListener(e -> JOptionPane.showMessageDialog(frame, WORD.aupdate[this.lang],
                WORD.cupdate[this.lang], JOptionPane.INFORMATION_MESSAGE));
        about.addActionListener(e -> abf.showaf(lang));
        jmfiles.addMenuListener(new MenuListener() {
            public void menuSelected(MenuEvent e) {
                jmisave.setEnabled(opened);
                jmisaveas.setEnabled(opened);
                jmiclose.setEnabled(opened);
            }

            public void menuDeselected(MenuEvent e) {
                // Nothing
            }

            public void menuCanceled(MenuEvent e) {
                // Nothing
            }
        });
        jmedit.addMenuListener(new MenuListener() {
            public void menuSelected(MenuEvent e) {
                setable();
            }

            public void menuDeselected(MenuEvent e) {
                // Nothing
            }

            public void menuCanceled(MenuEvent e) {
                // Nothing
            }
        });
        jmset.addMenuListener(new MenuListener() {
            public void menuSelected(MenuEvent e) {
                zin.setEnabled(tsize <= 98);
                zout.setEnabled(tsize >= 12);
            }

            public void menuDeselected(MenuEvent e) {
                // Nothing
            }

            public void menuCanceled(MenuEvent e) {
                // Nothing
            }
        });
    }

    public void newtff() {
        ttff = new TextFileFilter(".txt", "Text Files (*.txt)");
        ctff = new TextFileFilter(".c", "C Source file (*.c)");
        cpptff = new TextFileFilter(".cpp", "C++ Source File (*.cpp)");
        htff = new TextFileFilter(".h", "C++ Header File (*.h)");
        javatff = new TextFileFilter(".java", "JAVA Source File (*.java)");
        pytff = new TextFileFilter(".py", "Python Source File (*.py)");
        pascaltff = new TextFileFilter(".pas", "Pascal Source File (*.pas)");
        initff = new TextFileFilter(".ini", "Initialization File (*.ini)");
        dlltff = new TextFileFilter(".dll", "Dynamic Link Library (*.dll)");
        lrctff = new TextFileFilter(".lrc", "Lyric File (*.lrc)");
        nonetff = new TextFileFilter("", "UNKNOW");
        jfc.addChoosableFileFilter(ttff);
        jfc.addChoosableFileFilter(ctff);
        jfc.addChoosableFileFilter(cpptff);
        jfc.addChoosableFileFilter(htff);
        jfc.addChoosableFileFilter(javatff);
        jfc.addChoosableFileFilter(pytff);
        jfc.addChoosableFileFilter(pascaltff);
        jfc.addChoosableFileFilter(initff);
        jfc.addChoosableFileFilter(dlltff);
        jfc.addChoosableFileFilter(lrctff);
        jfc.addChoosableFileFilter(nonetff);
    }

    public void setsize(int c) {
        tsize = c;
        txt.setFont(new Font(fnt, Font.PLAIN, tsize));
    }

    public void sizechange(int c) {
        if (c == 0) {
            tsize = 18;
        } else if ((tsize >= 12 && c < 0) || (tsize <= 98 && c > 0)) {
            tsize += c;
        }
        txt.setFont(new Font(fnt, Font.PLAIN, tsize));
        jsl.setValue(tsize);
    }

    public String readtxt(File file) throws IOException {
        StringBuilder result = new StringBuilder();
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);) {
            String s = br.readLine();
            while (s != null) {// readLine
                result.append(s);
                s = br.readLine();
                if (s != null) {
                    result.append(System.lineSeparator());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public void writetxt(File file, String text) throws IOException {
        try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
                BufferedWriter bw = new BufferedWriter(osw);) {
            bw.write(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void changeLanguage() {
        if (lang == 0) {
            Locale.setDefault(Locale.ENGLISH);
            JComponent.setDefaultLocale(Locale.ENGLISH);
            bts.setFont(fo1);
            btsa.setFont(fo1);
        } else if (lang == 1) {
            Locale.setDefault(Locale.SIMPLIFIED_CHINESE);
            JComponent.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
            bts.setFont(fo1);
            btsa.setFont(fo1);
        } else if (lang == 2) {
            Locale.setDefault(Locale.TRADITIONAL_CHINESE);
            JComponent.setDefaultLocale(Locale.TRADITIONAL_CHINESE);
            bts.setFont(fo3);
            btsa.setFont(fo3);
        }
        frame.setTitle(WORD.title[this.lang]);
        jmfiles.setText(WORD.files[this.lang]);
        jmedit.setText(WORD.edit[this.lang]);
        jmset.setText(WORD.options[this.lang]);
        jmlan.setText(WORD.langu[this.lang]);
        jmscale.setText(WORD.scale[this.lang]);
        jmfont.setText(WORD.font[lang]);
        jmhelp.setText(WORD.help[this.lang]);
        jminew.setText(WORD.newf[this.lang]);
        jmiopen.setText(WORD.open[this.lang]);
        jmisave.setText(WORD.save[this.lang]);
        jmisaveas.setText(WORD.saveas[this.lang]);
        jmiclose.setText(WORD.close[this.lang]);
        jmiexit.setText(WORD.exit[this.lang]);
        copy.setText(WORD.copy[this.lang]);
        paste.setText(WORD.paste[this.lang]);
        cut.setText(WORD.cut[this.lang]);
        delete.setText(WORD.delete[this.lang]);
        checkAll.setText(WORD.select[this.lang]);
        undo.setText(WORD.undo[this.lang]);
        redo.setText(WORD.redo[this.lang]);
        zin.setText(WORD.zin[this.lang]);
        zout.setText(WORD.zout[this.lang]);
        zdft.setText(WORD.dft[this.lang]);
        find.setText(WORD.FIND[this.lang]);
        update.setText(WORD.update[this.lang]);
        about.setText(WORD.about[this.lang]);
        btn.setText(" " + WORD.newf[this.lang]);
        bto.setText(" " + WORD.open[this.lang]);
        bts.setText(" " + WORD.save[this.lang]);
        btsa.setText(" " + WORD.saveas[this.lang]);
        btc.setText(" " + WORD.close[this.lang]);
        bte.setText(" " + WORD.exit[this.lang]);
        dfnt.setText(WORD.dft[lang]);
        if (!opened) {
            label.setText(WORD.nopen[this.lang]);
        }
        txt.setMenuText(lang);
    }

    private void setable() {
        copy.setEnabled(txt.isCanCopy() && opened);
        paste.setEnabled(txt.isClipboardString() && opened);
        cut.setEnabled(txt.isCanCopy() && opened);
        delete.setEnabled(txt.isCanCopy() && opened);
        checkAll.setEnabled(opened);
        undo.setEnabled(txt.umcu() && opened);
        redo.setEnabled(txt.umcr() && opened);
        find.setEnabled(opened);
    }

    private void action(ActionEvent e) {
        String str = e.getActionCommand();
        if (str.equals(copy.getText())) {
            txt.copy();
        } else if (str.equals(paste.getText())) {
            txt.paste();
        } else if (str.equals(cut.getText())) {
            txt.cut();
        } else if (str.equals(delete.getText())) {
            txt.replaceSelection("");
        } else if (str.equals(checkAll.getText())) {
            txt.selectAll();
        } else if (str.equals(undo.getText()) && txt.umcu()) {
            txt.txtundo();
            undo.setEnabled(txt.umcu() && opened);
            redo.setEnabled(txt.umcr() && opened);
        } else if (str.equals(redo.getText()) && txt.umcr()) {
            txt.txtredo();
            undo.setEnabled(txt.umcu() && opened);
            redo.setEnabled(txt.umcr() && opened);
        }
    }

    private void btnew() {
        if (opened) {
            int chs = JOptionPane.showConfirmDialog(frame, WORD.overnew[this.lang], WORD.qsave[this.lang],
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            if (chs == 0) {
                try {
                    writetxt(f, txt.getText());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (chs == -1 || chs == 2)
                return;
        }
        jfc.setFileFilter(ttff);
        int ch = jfc.showSaveDialog(frame);
        File tempf = null;
        if (ch == JFileChooser.APPROVE_OPTION) {
            tempf = jfc.getSelectedFile();
            FileFilter testff = jfc.getFileFilter();
            if (!testff.getClass().toString().endsWith("AllFileFilter")) {
                TextFileFilter temptff = (TextFileFilter) testff;
                if (!tempf.getName().contains(".")) {
                    tempf = new File(tempf.getAbsolutePath() + temptff.getEnds());
                }
            }
            if (tempf.exists()) {
                int chs = JOptionPane.showConfirmDialog(frame, WORD.exist[this.lang], WORD.texist[this.lang],
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (chs == 0) {
                    f = tempf;
                    try {
                        writetxt(f, "");
                        txt.setText("");
                        txt.setEnabled(true);
                        txt.setBackground(txtco2);
                        opened = true;
                        label.setText(f.getAbsolutePath());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {
                f = tempf;
                try {
                    if (!f.createNewFile())
                        JOptionPane.showMessageDialog(frame, WORD.cfail[this.lang]);
                    else {
                        txt.setText("");
                        txt.setEnabled(true);
                        txt.setBackground(txtco2);
                        opened = true;
                        label.setText(f.getAbsolutePath());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            setable();
        }
    }

    private void btopen() {
        boolean tempc = true;
        if (opened) {
            int chs = JOptionPane.showConfirmDialog(frame, WORD.overopen[this.lang], WORD.qsave[this.lang],
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            if (chs == 0) {
                try {
                    writetxt(f, txt.getText());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (chs == -1 || chs == 2)
                tempc = false;
        }
        if (tempc) {
            jfc.setFileFilter(jfc.getAcceptAllFileFilter());
            int ch = jfc.showOpenDialog(frame);
            File tempf = null;
            if (ch == JFileChooser.APPROVE_OPTION) {
                tempf = jfc.getSelectedFile();
                if (tempf.exists()) {
                    f = tempf;
                    try {
                        txt.setText(readtxt(f));
                        txt.setEnabled(true);
                        txt.setBackground(txtco2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    opened = true;
                    label.setText(f.getAbsolutePath());
                } else
                    JOptionPane.showMessageDialog(frame, WORD.nofile[this.lang]);
            }
        }
        setable();
    }

    private void btsave() {
        if (opened) {
            try {
                writetxt(f, txt.getText());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(frame, WORD.nopen[this.lang] + "!");
        }
    }

    private void btsaveas() {
        if (opened) {
            jfc.setFileFilter(ttff);
            int ch = jfc.showSaveDialog(frame);
            File tempf = null;
            if (ch == JFileChooser.APPROVE_OPTION) {
                tempf = jfc.getSelectedFile();
                FileFilter testff = jfc.getFileFilter();
                if (!testff.getClass().toString().endsWith("AllFileFilter")) {
                    TextFileFilter temptff = (TextFileFilter) testff;
                    if (!tempf.getName().contains(".")) {
                        tempf = new File(tempf.getAbsolutePath() + temptff.getEnds());
                    }
                }
                if (tempf.exists()) {
                    int chs = JOptionPane.showConfirmDialog(frame, WORD.exist[this.lang], WORD.texist[this.lang],
                            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (chs == 0) {
                        f = tempf;
                        try {
                            writetxt(f, txt.getText());
                            label.setText(f.getAbsolutePath());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    f = tempf;
                    try {
                        if (!f.createNewFile())
                            JOptionPane.showMessageDialog(frame, WORD.cfail[this.lang]);
                        else {
                            writetxt(f, txt.getText());
                            label.setText(f.getAbsolutePath());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(frame, WORD.nopen[this.lang] + "!");
        }
        setable();
    }

    private void btclose() {
        if (opened) {
            int chs = JOptionPane.showConfirmDialog(frame,
                    WORD.saveclose1[this.lang] + f.getName() + WORD.saveclose2[this.lang], WORD.qsave[this.lang],
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            if (chs == 0) {
                try {
                    writetxt(f, txt.getText());
                    txt.setText("");
                    txt.setBackground(txtco);
                    txt.setEnabled(false);
                    opened = false;
                    label.setText(WORD.nopen[this.lang]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (chs == 1) {
                txt.setText("");
                txt.setBackground(txtco);
                txt.setEnabled(false);
                opened = false;
                label.setText(WORD.nopen[this.lang]);
            }
        } else {
            JOptionPane.showMessageDialog(frame, WORD.nopen[this.lang] + "!");
        }
        setable();
    }

    private void btexit() {
        if (opened) {
            int chs = JOptionPane.showConfirmDialog(frame,
                    WORD.saveexit1[this.lang] + f.getName() + WORD.saveexit2[this.lang], WORD.qsave[this.lang],
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            if (chs == 0) {
                try {
                    writetxt(f, txt.getText());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            } else if (chs == 1) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        } else {
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
    }

    private void createAndShowGUI() {
        new NewItem().execute();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            JFrame.setDefaultLookAndFeelDecorated(true);// Set Window
            JDialog.setDefaultLookAndFeelDecorated(true);// Set Dialogue
        } catch (Exception e) {
            e.printStackTrace();
        }
        javax.swing.SwingUtilities.invokeLater(() -> {
            LodingPanel nlp = new LodingPanel();
            nlp.showLoadingGUI();
            Exp2 mp = new Exp2(nlp);
            mp.createAndShowGUI();
        });
    }
}