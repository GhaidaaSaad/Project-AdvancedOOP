import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookFream extends JFrame {
	private JPanel panel;
	private JTextField titleField;
	private JTextField authorField;
	private JTextField isbnField;
	private JComboBox<String> genreBox;
	private JSpinner pageSpinner;
	private JTextArea descriptionArea;
	private JCheckBox newBox;
	private JRadioButton ebookButton;
	private JRadioButton hardcoverButton;
	private JRadioButton paperbackButton;
	private JSlider ratingSlider;
	private JLabel ratingLabel;
	private static final Font LABEL_FONT = new Font("Arial", Font.BOLD, 16);
	private static final Color BACKGROUND_COLOR = new Color(204, 229, 255);
	private static final Color FOREGROUND_COLOR = new Color(0, 51, 102);
	private static final Color BORDER_COLOR = new Color(0, 51, 102);
	public BookFream (){
		setTitle("Library Book Input Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 700);
		setLayout(new BorderLayout());
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panel.setBackground(BACKGROUND_COLOR);
		add(panel, BorderLayout.CENTER);
		ImageIcon bookIcon = new ImageIcon("src/book.png");
		Image bookImage = bookIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		JLabel imageLabel = new JLabel(new ImageIcon(bookImage));
		add(imageLabel, BorderLayout.NORTH);
		JLabel titleLabel = new JLabel("Title:");
		titleLabel.setForeground(FOREGROUND_COLOR);
		titleLabel.setFont(LABEL_FONT);
		titleField = new JTextField(20);
		titleField.setBackground(BACKGROUND_COLOR);
		titleField.setBorder(BorderFactory.createLineBorder(BORDER_COLOR));
		titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		titleField.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(titleLabel);
		panel.add(titleField);
		JLabel authorLabel = new JLabel("Author:");
		authorLabel.setForeground(FOREGROUND_COLOR);
		authorLabel.setFont(LABEL_FONT);
		authorField = new JTextField(20);
		authorField.setBackground(BACKGROUND_COLOR);
		authorField.setBorder(BorderFactory.createLineBorder(BORDER_COLOR));
		authorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		authorField.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(authorLabel);
		panel.add(authorField);
		JLabel isbnLabel = new JLabel("ISBN:");
		isbnLabel.setForeground(FOREGROUND_COLOR);
		isbnLabel.setFont(LABEL_FONT);
		isbnField = new JTextField(20);
		isbnField.setBackground(BACKGROUND_COLOR);
		isbnField.setBorder(BorderFactory.createLineBorder(BORDER_COLOR));
		isbnLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		isbnField.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(isbnLabel);
		panel.add(isbnField);
		JLabel genreLabel = new JLabel("Genre:");
		genreLabel.setForeground(FOREGROUND_COLOR);
		genreLabel.setFont(LABEL_FONT);
		String[] genres = {"Fiction", "Non-Fiction", "Biography", "Fantasy"};
		genreBox = new JComboBox<String>(genres);
		genreBox.setBackground(BACKGROUND_COLOR);
		genreBox.setBorder(BorderFactory.createLineBorder(BORDER_COLOR));
		genreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		genreBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(genreLabel);
		panel.add(genreBox);
		newBox = new JCheckBox("New");
		newBox.setForeground(FOREGROUND_COLOR);
		newBox.setFont(LABEL_FONT);
		newBox.setBackground(BACKGROUND_COLOR);
		newBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(newBox);
		ebookButton = new JRadioButton("Ebook");
		hardcoverButton = new JRadioButton("Hardcover");
		paperbackButton = new JRadioButton("Paper");
		ButtonGroup formatGroup = new ButtonGroup();
		formatGroup.add(ebookButton);
		formatGroup.add(hardcoverButton);
		formatGroup.add(paperbackButton);
		JLabel formatLabel = new JLabel("Format:");
		formatLabel.setForeground(FOREGROUND_COLOR);
		formatLabel.setFont(LABEL_FONT);
		ebookButton.setForeground(FOREGROUND_COLOR);
		ebookButton.setFont(LABEL_FONT);
		ebookButton.setBackground(BACKGROUND_COLOR);
		ebookButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		hardcoverButton.setForeground(FOREGROUND_COLOR);
		hardcoverButton.setFont(LABEL_FONT);
		hardcoverButton.setBackground(BACKGROUND_COLOR);
		hardcoverButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		paperbackButton.setForeground(FOREGROUND_COLOR);
		paperbackButton.setFont(LABEL_FONT);
		paperbackButton.setBackground(BACKGROUND_COLOR);
		paperbackButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		formatLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(formatLabel);
		panel.add(ebookButton);
		panel.add(hardcoverButton);
		panel.add(paperbackButton);
		JLabel pageLabel = new JLabel("Number of Pages:");
		pageLabel.setForeground(FOREGROUND_COLOR);
		pageLabel.setFont(LABEL_FONT);
		SpinnerModel pageModel = new SpinnerNumberModel(100, 0, 1000, 25);
		pageSpinner = new JSpinner(pageModel);
		pageSpinner.setBackground(BACKGROUND_COLOR);
		pageSpinner.setBorder(BorderFactory.createLineBorder(BORDER_COLOR));
		pageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		pageSpinner.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(pageLabel);
		panel.add(pageSpinner);
		JLabel descLabel = new JLabel("Description:");
		descLabel.setForeground(FOREGROUND_COLOR);
		descLabel.setFont(LABEL_FONT);
		descriptionArea = new JTextArea(4, 20);
		descriptionArea.setBackground(BACKGROUND_COLOR);
		descriptionArea.setBorder(BorderFactory.createLineBorder(BORDER_COLOR));
		JScrollPane scrollPane = new JScrollPane(descriptionArea);
		descLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(descLabel);
		panel.add(scrollPane);
		ratingLabel = new JLabel("Rating:");
		ratingLabel.setForeground(FOREGROUND_COLOR);
		ratingLabel.setFont(LABEL_FONT);
		ratingSlider = new JSlider(1, 5);
		ratingSlider.setBackground(BACKGROUND_COLOR);
		ratingSlider.setBorder(BorderFactory.createLineBorder(BORDER_COLOR));
		ratingSlider.addChangeListener(e -> {
			int value = ratingSlider.getValue();
			ratingLabel.setText("Rating: " + value);
			});

		ratingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		ratingSlider.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(ratingLabel);
		panel.add(ratingSlider);
		JButton submitButton = new JButton("Submit");
		submitButton.setForeground(FOREGROUND_COLOR);
		submitButton.setBackground(BACKGROUND_COLOR);
		submitButton.setFont(LABEL_FONT);
		submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		submitButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		submitForm();
		}
		});
		panel.add(submitButton);
		setVisible(true);
		}
		private void submitForm() {
		String title = titleField.getText();
		String author = authorField.getText();
		String isbn = isbnField.getText();
		String genre = (String) genreBox.getSelectedItem();
		boolean isNew = newBox.isSelected();
		int pages = (int) pageSpinner.getValue();
		String description = descriptionArea.getText();
		int rating = ratingSlider.getValue();
		String format = "";
		if (ebookButton.isSelected()) {
		format = "Ebook";
		} else if (hardcoverButton.isSelected()) {
		format = "Hardcover";
		} else if (paperbackButton.isSelected()) {
		format = "Paperback";
		}
		String message = "Title: " + title + "\n" +
		"Author: " + author + "\n" +
		"ISBN: " + isbn + "\n" +
		"Genre: " + genre + "\n" +
		"NEW: " + isNew + "\n" +
		"Format: " + format + "\n" +
		"Number of Pages: " + pages + "\n" +
		"Description: " + description + "\n" +
		"Rating: " + rating;
		JOptionPane.showMessageDialog(this, message);
		}
		public static void main(String[] args) {
		new BookFream();
		}
		}



