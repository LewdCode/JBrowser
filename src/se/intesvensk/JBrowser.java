package se.intesvensk;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.browser.Browser;

import java.util.Random;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.browser.LocationAdapter;
import org.eclipse.swt.browser.LocationEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
//import org.eclipse.swt.widgets.Combo;

public class JBrowser {

	private Random rand = new Random();
	protected Shell shlJbrowser;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			JBrowser window = new JBrowser();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlJbrowser.open();
		shlJbrowser.layout();
		while (!shlJbrowser.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlJbrowser = new Shell(SWT.CLOSE | SWT.TITLE | SWT.BORDER |
				SWT.APPLICATION_MODAL | SWT.MIN );
		shlJbrowser.setMinimumSize(new Point(800, 650));
		shlJbrowser.setSize(800, 550);
		shlJbrowser.setText("JBrowser");		
		shlJbrowser.setLayout(null);
		Browser browser = new Browser(shlJbrowser, SWT.NONE);
		browser.setBounds(10, 68, 764, 433);


		
		browser.addLocationListener(new LocationAdapter() {
			@Override
			public void changed(LocationEvent event) {
				if(text_1.getText().contentEquals("BEST GAME EVER!")){
					//TODO add code
				}else{
					text.setText(browser.getUrl());
				}
			}});
		
		text = new Text(shlJbrowser, SWT.BORDER);
		text.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				text.selectAll();
			}
		});
		text.setBounds(58, 10, 489, 21);
		text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.keyCode == 13){
					if(!(text.getText().contains(" ")) && text.getText().contains(".")){
						if(!(text.getText().startsWith("javascript:"))){
							browser.setUrl(text.getText());
						}else{
							MessageDialog.openWarning(shlJbrowser, "Warning!", "This address bar isn't ideal for Javascript. Please use the dedicated bar.");
							text.setText("");
						}
						
					}else{
						if(!(text.getText().startsWith("javascript:"))){
							String query = text.getText();
							query.replace(" ", "+");
							browser.setUrl("http://google.com/search?q=" + query);
							}else{
							MessageDialog.openWarning(shlJbrowser, "Warning!", "This address bar isn't ideal for Javascript. Please use the dedicated bar.");
							text.setText("");
						}
						
					}
				}
			}
		});
		
		Button btnNewButton = new Button(shlJbrowser, SWT.NONE);
		btnNewButton.setBounds(566, 10, 128, 21);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!(text.getText().isEmpty())){
					if(!(text.getText().startsWith("javascript:"))){
						browser.setUrl(text.getText());
					}else{
						MessageDialog.openWarning(shlJbrowser, "Warning!", "This address bar isn't ideal for Javascript. Please use the dedicated bar.");
						text.setText("");
					}
	//				combo.add(text.getText());
				}
				switch (rand.nextInt(10)){
				
				case 0:
					btnNewButton.setText("Go");
					break;
				case 1:
					btnNewButton.setText("Submit");
					break;
				case 2:
					btnNewButton.setText("Attack!");
					break;
				case 3:
					btnNewButton.setText("Take Me Thar!");
					break;
				case 4:
					btnNewButton.setText("Visit");
					break;
				case 5:
					btnNewButton.setText("Proceed");
					break;
				case 6:
					btnNewButton.setText("Next");
					break;
				case 7:
					btnNewButton.setText("...");
					break;
				case 8:
					btnNewButton.setText("submitButton.getText()");
					break;
				case 9:
					btnNewButton.setText("null");
					break;
					
				}
			}
		});
		btnNewButton.setText("Take Me Thar");
		
		Button button = new Button(shlJbrowser, SWT.NONE);
		button.setBounds(10, 8, 20, 25);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				browser.setUrl("javascript:window.history.go(-1)");
			}
		});
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				//text.setText(browser.getUrl());
			}
		});
		button.setText("<");
		
		Button button_1 = new Button(shlJbrowser, SWT.NONE);
		button_1.setBounds(32, 8, 20, 25);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				browser.setUrl("javascript:window.history.go(1)");
			}
		});
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			//browser.setUrl("javascript:window.history.go(1)");
				browser.refresh();
			
			}
		});
		button_1.setText("@");
		
		Label lblExecuteJavascript = new Label(shlJbrowser, SWT.NONE);
		lblExecuteJavascript.setBounds(10, 40, 99, 15);
		lblExecuteJavascript.setText("Execute Javascript");
		
		text_1 = new Text(shlJbrowser, SWT.BORDER);
		text_1.setBounds(115, 37, 417, 21);
		
		Button button_2 = new Button(shlJbrowser, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				HelpWindow help = new HelpWindow();
				help.open();
			}
		});
		button_2.setBounds(541, 37, 33, 25);
		button_2.setText("?");
		
		Button btnRun = new Button(shlJbrowser, SWT.NONE);
		btnRun.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			if(!(text_1.getText().startsWith("javascript:"))){
				if(text_1.getText().contentEquals("BESTGAMEEVER!")){
					MessageDialog.openInformation(shlJbrowser, "Now Going!", "The best game ever is...");
					browser.setUrl("https://play.google.com/store/apps/details?id=com.Kyuppin.DiggyDig");
					text.setText(text_1.getText());
				}else if(text_1.getText().contentEquals("BESTGAMEDEVEVER!")){
					browser.setUrl("https://twitter.com/LolicOnion");
					text.setText(text_1.getText());
					
				}else{
				MessageDialog.openInformation(shlJbrowser, "Information!", "You must start a javascript HTML script with 'javascript:'");
				}
			}else{
				browser.setUrl(text_1.getText());
			}
			}
		});
		btnRun.setBounds(576, 37, 42, 25);
		btnRun.setText("Run");
		
		Label lblImFeelingUnlucky = new Label(shlJbrowser, SWT.NONE);
		lblImFeelingUnlucky.setBounds(10, 508, 161, 15);
		lblImFeelingUnlucky.setText("I'm Feeling Unlucky Search");
		text_2 = new Text(shlJbrowser, SWT.BORDER);
		text_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.keyCode == 13){
					//do later
				}
			}
		});
		text_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
			text_2.selectAll();
			}
		});
		text_2.setBounds(10, 529, 297, 21);
		
		Button btnNewButton_1 = new Button(shlJbrowser, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String query = text_2.getText();
				query.replace(" ", "+");
				switch (rand.nextInt(25)){
				case 0:
					browser.setUrl("http://bing.com/search?q=" + query);
					break;
				case 1:
					browser.setUrl("http://duckduckgo.com/search?q=" + query);
					break;
				case 2:
					browser.setUrl("http://www.gigablast.com/search?c=main&q=" + query);
					break;
				case 3:
					browser.setUrl("http://google.com/search?q=" + query);
					break;
				case 4:
					browser.setUrl("http://qwant.com/?q=" + query);
					break;
				case 5:
					browser.setUrl("http://www.yandex.com/search/?text=" + query);
					break;
				case 6:
					browser.setUrl("http://faroo.com/#q=" + query);
					break;
				case 7:
					browser.setUrl("http://webmd.com/search/search_results/default.aspx?query=" + query);
					break;
				case 8:
					browser.setUrl("http://youtube.com/results?search_query=" + query);
					break;
				case 9:
					browser.setUrl("http://ask.com/web?q=" + query);
					break;
				case 10:
					browser.setUrl("http://reddit.com/search?q=" + query);
					break;
				case 11: 
					browser.setUrl("http://imgur.com/search?q=" + query);
					break;
				case 12:
					browser.setUrl("http://facebook.com/search/stc/" + query + "/keywords+top");
					break;
				case 13:
					browser.setUrl("http://twitter.com/search?q=" + query);
					break;
				case 14:
					browser.setUrl("http://en.wikipedia.org/w/index.php?search=" + query);
					break;
				case 15:
					browser.setUrl("http://urbandictionary.com/define.php?term=" + query);
					break;
				case 16:
					browser.setUrl("http://search.whitehouse.gov/search?query=" + query);
					break;
				case 17:
					browser.setUrl("http://www.australia.gov.au/search/site/" + query);
					break;
				case 18:
					browser.setUrl("http://fbi.gov%2F&q=" + query);
					break;
				case 19:
					browser.setUrl("http://ea.com/search?q=" + query);
					break;
				case 20:
					browser.setUrl("http://ign.com/search?q=" + query);
					break;
				case 21:
					browser.setUrl("http://services.runescape.com/m=forum/searchthreads.ws?search=submit&srcstr=" + query);
					break;
				case 22:
					browser.setUrl("http://tumblr.com/search/" + query);
					break;
				case 23:
					browser.setUrl("http://store.steampowered.com/search/?snr=1_4_4__12&term=" + query);
					break;
				case 24:
					browser.setUrl("http://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&ch=&tn=baidu&bar=&wd=" + query);
					break;
				}
			}
		});
		btnNewButton_1.setBounds(313, 529, 121, 21);
		btnNewButton_1.setText("I'm Feeling Unlucky");
		
		Label lblCommands = new Label(shlJbrowser, SWT.NONE);
		lblCommands.setBounds(10, 556, 71, 15);
		lblCommands.setText("Commands");
		Label label = new Label(shlJbrowser, SWT.NONE);
		text_3 = new Text(shlJbrowser, SWT.BORDER);
		text_3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				label.setText("     ");
			}
		});
		
		text_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.keyCode == 13){
					//TODO Work out why this doesnt work
				}
			}
		});
		text_3.setToolTipText("To execute a command, press END. \r\n\r\nCommands are essentially quick links to certain sites.\r\nFor a full list of commands, type \"list\"\r\n\r\nIf you would like to suggest a command, email intesvensk15@gmail.com");
		text_3.setBounds(10, 580, 297, 21);
		
		//Label label = new Label(shlJbrowser, SWT.NONE);
		label.setBounds(361, 580, 413, 21);
		label.setText("     ");
		
		Button btnRun_1 = new Button(shlJbrowser, SWT.NONE);
		btnRun_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(text_3.getText().equalsIgnoreCase("list")){
					//MessageDialog.openInformation(shlJbrowser, "Command List", "Test. Test");
					MessageDialog.openConfirm(shlJbrowser, "Command: " + text_3.getText(), "Test \r\nTest");
					label.setText("Command Run!");
				}else if(text_3.getText().equalsIgnoreCase("disableJS")){
					MessageDialog.openConfirm(shlJbrowser, "Command: " + text_3.getText(), "JavaScript Execution Bar disabled");
					text_1.setEnabled(false);
					btnRun.setEnabled(false);
					label.setText("Command Run!");
				}else if(text_3.getText().equalsIgnoreCase("enableJS")){
					MessageDialog.openConfirm(shlJbrowser, "Command: " + text_3.getText(), "JavaScript Execution Bar enabled");
					text_1.setEnabled(true);
					btnRun.setEnabled(true);
					label.setText("Command Run!");
				}else{
					label.setText("Command Not Recognised!");
				}
			}
		});
		btnRun_1.setBounds(313, 580, 42, 21);
		btnRun_1.setText("Run");
		

	}
}
