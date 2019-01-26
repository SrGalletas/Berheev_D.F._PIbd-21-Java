package lab1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Air {
	private float _startPosX;
	private float _startPosY;
	private int _pictureWidth;
	private int _pictureHeight;
	private int airWidth = 200;
	private int airHeight = 60;
	private int MaxSpeed;

	public int getMaxSpeed() {
		return MaxSpeed;
	}

	private void setMaxSpeed(int value) {
		MaxSpeed = value;
	}

	private float Weight;

	public float getWeight() {
		return Weight;
	}

	private void setWeight(float value) {
		Weight = value;
	}

	private Color MainColor;

	public Color getMainColor() {
		return MainColor;
	}

	private void setMainColor(Color value) {
		MainColor = value;
	}

	private Color DopColor;

	public Color getDopColor() {
		return DopColor;
	}

	private void setDopColor(Color value) {
		DopColor = value;
	}

	public Air(int maxSpeed, float weight, Color mainColor, Color dopColor) {
		setMaxSpeed(maxSpeed);
		setWeight(weight);
		setMainColor(mainColor);
		setDopColor(dopColor);
	}

	public void SetPosition(int x, int y, int width, int height) {
		_startPosX = x;
		_startPosY = y;
		_pictureWidth = width;
		_pictureHeight = height;
	}

	public void MoveTransport(Direction direction) {

		float step = getMaxSpeed() * 100 / getWeight();
		switch (direction) {
		case Right:
			if (_startPosX + step < _pictureWidth - airWidth) {
				_startPosX += step;
			}
			break;
		case Left:
			if (_startPosX - step > 0) {
				_startPosX -= step;
			}
			break;
		case Up:
			if (_startPosY - step - 10 > 0) {
				_startPosY -= step;
			}
			break;
		case Down:
			if (_startPosY + step < _pictureHeight - airHeight) {
				_startPosY += step;
			}
			break;
		}
	}

	public void DrawAir(Graphics g) {
		Color newColor = new Color(0, 0, 0);
		g.setColor(newColor);
		g.fillRect((int) _startPosX + 15, (int) _startPosY - 5, 15, 10);
		g.fillRect((int) _startPosX + 17, (int) _startPosY - 2, 11, 4);
		g.fillRect((int) _startPosX + 15, (int) _startPosY + 43, 15, 10);
		g.fillRect((int) _startPosX + 17, (int) _startPosY + 46, 11, 4);
		g.setColor(MainColor);
		g.drawOval((int) _startPosX - 5, (int) _startPosY + 15, 100, 20);
		g.fillOval((int) _startPosX - 5, (int) _startPosY + 15, 100, 20);
		Graphics2D i = (Graphics2D) g;
		BasicStroke pen1 = new BasicStroke(10);
		i.setStroke(pen1);
		i.drawLine((int) _startPosX + 20, (int) _startPosY - 20,
				(int) _startPosX + 45, (int) _startPosY + 25);
		i.drawLine((int) _startPosX + 20, (int) _startPosY + 65,
				(int) _startPosX + 45, (int) _startPosY + 25);
		i.drawLine((int) _startPosX - 15, (int) _startPosY, (int) _startPosX,
				(int) _startPosY + 23);
		g.setColor(DopColor);
		Graphics2D s = (Graphics2D) g;
		BasicStroke pen2 = new BasicStroke(2);
		s.setStroke(pen2);
		s.fillOval((int) _startPosX + 15, (int) _startPosY + 20, 10, 10);
		s.drawOval((int) _startPosX + 15, (int) _startPosY + 20, 10, 10);
		s.fillOval((int) _startPosX + 30, (int) _startPosY + 20, 10, 10);
		s.drawOval((int) _startPosX + 30, (int) _startPosY + 20, 10, 10);
		s.fillOval((int) _startPosX + 45, (int) _startPosY + 20, 10, 10);
		s.drawOval((int) _startPosX + 45, (int) _startPosY + 20, 10, 10);
		s.fillOval((int) _startPosX + 60, (int) _startPosY + 20, 10, 10);
		s.drawOval((int) _startPosX + 60, (int) _startPosY + 20, 10, 10);
		Color newColor1 = new Color(255, 255, 255);
		g.setColor(newColor1);
		Graphics2D z = (Graphics2D) g;
		BasicStroke pen3 = new BasicStroke(3);
		z.setStroke(pen3);
		z.drawLine((int) _startPosX + 80,(int) _startPosY + 20,(int) _startPosX + 90,(int) _startPosY + 25);
	}
}
