package se.intesvensk;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;

public class HelpWindow {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			HelpWindow window = new HelpWindow();
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		List list = new List(shell, SWT.BORDER);
		list.setEnabled(false);
		list.setItems(new String[] {"Welcome to the JBrowser Javascript Help page", "", "If you would like to run custom javascript in this browser, enter the desired code ", "in the Execute Javascript bar, headed with \"javascript:\"", "", "Once you are ready to run it, press \"Run\""});

	}

}
