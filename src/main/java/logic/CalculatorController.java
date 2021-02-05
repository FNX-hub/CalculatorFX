package logic;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class CalculatorController {
	
	@FXML
	private Label lblResult;
	@FXML
	private Button btnClear;
	
	@FXML
	private GridPane gpButtons;
	
	@FXML
	private Button btn7;
	@FXML
	private Button btn8;
	@FXML
	private Button btn9;
	@FXML
	private Button btnAdd;
	
	@FXML
	private Button btn4;
	@FXML
	private Button btn5;
	@FXML
	private Button btn6;
	@FXML
	private Button btnSub;
	
	@FXML
	private Button btn1;
	@FXML
	private Button btn2;
	@FXML
	private Button btn3;
	@FXML
	private Button btnMul;
	
	@FXML
	private Button btnDot;
	@FXML
	private Button btn0;
	@FXML
	private Button btnDiv;
	@FXML
	private Button btnEqn;
		
	private Double ans = null;
	private Double operand = null;
	private Boolean append = false;
	private Operation op = Operation.NULL;
	
	@FXML
	private void onClickClear() {
		gpButtons.setDisable(false);
		lblResult.setText("0");
		op = Operation.NULL;
		ans = null;
		operand = null;
		append = false;
	}
	
	@FXML
	private void onClickAdd() {
		operand = Double.parseDouble(lblResult.getText());
		if (append.booleanValue()) {
			update();
		}
		op = Operation.SUM;
	}
	
	@FXML
	private void onClickSub() {
		operand = Double.parseDouble(lblResult.getText());
		if (append.booleanValue()) {
			update();
		}
		op = Operation.SUBTRACTION;
	}
	
	@FXML
	private void onClickMul() {
		operand = Double.parseDouble(lblResult.getText());
		if (append.booleanValue()) {
			update();
		}
		op = Operation.MOLTIPLICATION;
	}
	
	@FXML
	private void onClickDiv() {
		operand = Double.parseDouble(lblResult.getText());
		if (append.booleanValue()) {
			update();
		}
		op = Operation.DIVISION;
	}
	
	@FXML
	private void onClickEqn() {
		try { 
			operand = Double.parseDouble(lblResult.getText());
		} catch (Exception e) {
			if (operand == null) {
				operand = 0.0;
			}
		}
		if (append.booleanValue()) {
			update();
		}
		op = Operation.EQUAL;
	}
	
	@FXML
	private void onClick7() {
		if (append.booleanValue()) {
			lblResult.setText(lblResult.getText()+"7");
		}
		else {
			lblResult.setText("7");
			append = true;
		}
	}
	@FXML
	private void onClick8() {
		if (append.booleanValue()) {
			lblResult.setText(lblResult.getText()+"8");
		}
		else {
			lblResult.setText("8");
			append = true;
		}
	}
	@FXML
	private void onClick9() {
		if (append.booleanValue()) {
			lblResult.setText(lblResult.getText()+"9");
		}
		else {
			lblResult.setText("9");
			append = true;
		}
	}
	
	@FXML
	private void onClick4() {
		if (append.booleanValue()) {
			lblResult.setText(lblResult.getText()+"4");
		}
		else {
			lblResult.setText("4");
			append = true;
		}
	}
	@FXML
	private void onClick5() {
		if (append.booleanValue()) {
			lblResult.setText(lblResult.getText()+"5");
		}
		else {
			lblResult.setText("5");
			append = true;
		}
	}
	@FXML
	private void onClick6() {
		if (append.booleanValue()) {
			lblResult.setText(lblResult.getText()+"6");
		}
		else {
			lblResult.setText("6");
			append = true;
		}
	}
	
	@FXML
	private void onClick1() {
		if (append.booleanValue()) {
			lblResult.setText(lblResult.getText()+"1");
		}
		else {
			lblResult.setText("1");
			append = true;
		}
	}
	@FXML
	private void onClick2() {
		if (append.booleanValue()) {
			lblResult.setText(lblResult.getText()+"2");
		}
		else {
			lblResult.setText("2");
			append = true;
		}
	}
	@FXML
	private void onClick3() {
		if (append.booleanValue()) {
			lblResult.setText(lblResult.getText()+"3");
		}
		else {
			lblResult.setText("3");
			append = true;
		}
	}
	
	@FXML
	private void onClickDot() {
		if (!lblResult.getText().contains(".")) {
			lblResult.setText(lblResult.getText()+".");
			append = true;
		}
	}
	@FXML
	private void onClick0() {
		if (append.booleanValue() && !lblResult.getText().equals("0")) {
			lblResult.setText(lblResult.getText()+"0");
		}
		else {
			lblResult.setText("0");
			append = true;
		}
	}
	
	private void update() {
		if (operand == null) {
			operand = 0.0;
		}
		switch(op) {
			case SUM:
				ans += operand;
				break;
			case SUBTRACTION:
				ans -= operand;
				break;
			case MOLTIPLICATION:
				ans *= operand;
				break;
			case DIVISION:
				if (ans == 0 && operand == 0) {
					lblResult.setText("NaN");
					ans = null;
				}
				else if (operand == 0) {
					lblResult.setText("Infinity");
					ans = null;
				}
				else {
					ans /= operand;
				}
				break;

			case EQUAL:
				ans = operand;
				break;

			default:
				if (ans == null) {
					ans = operand;
				}
				break;
		}
		if (ans != null) {
			lblResult.setText(ans.toString());
		} else {
			gpButtons.setDisable(true);			
		}
		if (lblResult.getText().equals("0.0")) {
			lblResult.setText("0");
		}
		operand = null;
		append = false;
	}
}