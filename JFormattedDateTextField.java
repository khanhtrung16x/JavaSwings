
import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JFormattedDateTextField extends JFormattedTextField {
	Format format = new SimpleDateFormat("dd/MM/yyyy");

	public JFormattedDateTextField() {
		super();
		MaskFormatter maskFormatter = null;
		try {
			maskFormatter = new MaskFormatter("##/##/####");
		} catch (ParseException ew) {
			ew.printStackTrace();
		}

		maskFormatter.setPlaceholderCharacter(' ');
		setFormatterFactory(new DefaultFormatterFactory(maskFormatter));
		this.addFocusListener(new FocusAdapter() {
			public void FocusGained(FocusEvent ew) {
				if (getFocusLostBehavior() == JFormattedTextField.PERSIST)
					setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
			}

			public void focusLost(FocusEvent ew) {
				try {
					Date date = (Date) format.parseObject(getText());
					setValue(format.format(date));
				} catch (ParseException p) {
					setFocusLostBehavior(JFormattedTextField.PERSIST);
					setText("");
					setValue(null);
				}
			}
		});
	}

	public void setValue(Date date) {
		super.setValue(toString(date));
	}

	private String toString(Date date) {
		try {
			return format.format(date);
		} catch (Exception e) {
			return "";
		}
	}
}
