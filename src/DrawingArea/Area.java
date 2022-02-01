/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DrawingArea;

import finalproject.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class Area extends JPanel implements MouseListener, MouseMotionListener {

    Color currentColor = Color.BLACK;
    private int x1, y1, x2, y2, x3, y3;
    private int xi, yi, xf, yf, xT, yT;
    private int increaseSide;
    private int index;
    private int xcopy = 50, ycopy = 10;
    boolean isFilled = false, selected = false;
    char action;
    private boolean first = false;

    static ArrayList<Shape> shapesInArea = new ArrayList<Shape>();
    static Stack<Undo> unDo = new Stack<Undo>();
    static Stack<Undo> reDo = new Stack<Undo>();

    char choice;

    public Area() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Iterator<Shape> it = shapesInArea.iterator();//design pattern

        while (it.hasNext()) {
            Shape shapeToDraw = it.next();
            if (shapeToDraw instanceof Line) {
                Line l = (Line) shapeToDraw;
                l.draw(g);
            } else if (shapeToDraw instanceof Rectangle) {
                Rectangle r = (Rectangle) shapeToDraw;
                r.draw(g);

            } else if (shapeToDraw instanceof Square) {
                Square sq = (Square) shapeToDraw;
                sq.draw(g);

            } else if (shapeToDraw instanceof Triangle) {
                Triangle t = (Triangle) shapeToDraw;
                t.draw(g);

            } else if (shapeToDraw instanceof Circle) {
                Circle c = (Circle) shapeToDraw;
                c.draw(g);
            } else if (shapeToDraw instanceof Oval) {
                Oval o = (Oval) shapeToDraw;
                o.draw(g);
            }
        }

    }

    private char whichShape(Shape s) {
        if (s instanceof Line) {
            return 'L';
        }
        if (s instanceof Circle) {
            return 'C';
        }
        if (s instanceof Oval) {
            return 'O';
        }
        if (s instanceof Square) {
            return 'S';
        }
        if (s instanceof Rectangle) {
            return 'R';
        }
        if (s instanceof Triangle) {
            return 'T';
        }
        if (s instanceof RightAngledTriangle) {
            return 'A';
        }
        return 'n';
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        switch (action) {
            case 'D': {
                for (int i = shapesInArea.size() - 1; i >= 0; i--) {
                    if (shapesInArea.get(i).isSelected(x, y)) {
                        Undo u = new Undo('D', shapesInArea.get(i).getColor(), shapesInArea.get(i).isIsFilled(), shapesInArea.get(i).getX1(), shapesInArea.get(i).getX2(), shapesInArea.get(i).getY1(), shapesInArea.get(i).getY2());
                        u.setShape(whichShape(shapesInArea.get(i)));
                        if (shapesInArea.get(i) instanceof Triangle) {

                            Triangle t = (Triangle) shapesInArea.get(i);
                            u.setX3(t.getX3());
                            u.setY3(t.getY3());
                        }
                        if (shapesInArea.get(i) instanceof RightAngledTriangle) {

                            RightAngledTriangle rt = (RightAngledTriangle) shapesInArea.get(i);
                            u.setX3(rt.getX3());
                            u.setY3(rt.getY3());
                        }
                        shapesInArea.remove(i);
                        unDo.push(u);
                        repaint();

                        break;
                    }

                }

            }

            case 'C': {
                for (int i = shapesInArea.size() - 1; i >= 0; i--) {
                    if (shapesInArea.get(i).isSelected(x, y)) {

                        try {
                            index = i;
                            Shape copied = (Shape) shapesInArea.get(i).clone();
                            getCoordinates();
                            if (xi < 0 || xf > 560) {
                                xcopy = -xcopy;
                            }
                            if (yi < 0 || yf > 360) {
                                ycopy = -ycopy;
                            }
                            moveShape(0, 0, xcopy, ycopy);

                            shapesInArea.add(shapesInArea.get(i));
                            shapesInArea.set(index, copied);
                            Shape s = shapesInArea.get(i);
                            Undo u = new Undo(shapesInArea.size() - 1, 'C', s.getColor(), s.isIsFilled(), s.getX1(), s.getX2(), s.getY1(), s.getY2());
                            u.setShape(whichShape(copied));
                            if (s instanceof Triangle) {

                                Triangle t = (Triangle) s;
                                u.setX3(t.getX3());
                                u.setY3(t.getY3());
                            }
                            if (s instanceof RightAngledTriangle) {

                                RightAngledTriangle rt = (RightAngledTriangle) s;
                                u.setX3(rt.getX3());
                                u.setY3(rt.getY3());
                            }
                            unDo.push(u);
                            repaint();

                        } catch (CloneNotSupportedException ex) {
                            Logger.getLogger(Area.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        break;
                    }
                }
            }
            case 'F': {
                for (int i = shapesInArea.size() - 1; i >= 0; i--) {
                    if (shapesInArea.get(i).isSelected(x, y)) {
                        index = i;

                        Shape s = shapesInArea.get(i);
                        Undo u = new Undo(index, 'F', s.getColor(), s.isIsFilled(), s.getX1(), s.getX2(), s.getY1(), s.getY2());
                        u.setShape(whichShape(s));
                        unDo.push(u);

                        shapesInArea.get(i).changeFill();
                        shapesInArea.get(i).setColor(currentColor);

                        repaint();
                        break;
                    }

                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e
    ) {
        x1 = e.getX();
        y1 = e.getY();

        if (action == 'P') {
            ShapeFactory sFactory = new ShapeFactory();
            Shape shape = sFactory.createShape(choice, currentColor, isFilled, x1, x1, y1, y1);
            if (shape instanceof RightAngledTriangle) {
                RightAngledTriangle rt = (RightAngledTriangle) shape;
                rt.setX3(x1);
                rt.setY3(y1);
            } else if (shape instanceof Triangle) {
                Triangle t = (Triangle) shape;
                t.setX3(x1);
                t.setY3(y1);
            }
            shapesInArea.add(shape);

            repaint();
        } else if (action == 'M' || action == 'Z') {
            selected = false;
            for (int i = shapesInArea.size() - 1; i >= 0; i--) {
                if (shapesInArea.get(i).isSelected(x1, y1)) {
                    selected = true;
                    index = i;
                    getCoordinates();
                    break;
                }

            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e
    ) {

    }

    @Override
    public void mouseEntered(MouseEvent e
    ) {

    }

    @Override
    public void mouseExited(MouseEvent e
    ) {

    }

    private void getCoordinates() {
        xi = shapesInArea.get(index).getX1();
        yi = shapesInArea.get(index).getY1();
        xf = shapesInArea.get(index).getX2();
        yf = shapesInArea.get(index).getY2();
        if (shapesInArea.get(index) instanceof Square || shapesInArea.get(index) instanceof Circle) {

            if (xf > yf) {
                increaseSide = Math.abs(xf - xi);
            } else {
                increaseSide = Math.abs(yf - yi);
            }

            xf = Math.min(xi, xf) + increaseSide;
            yf = Math.min(yi, yf) + increaseSide;
        } else if (shapesInArea.get(index) instanceof RightAngledTriangle) {

            xT = xi;
            yT = yf;

        } else if (shapesInArea.get(index) instanceof Triangle) {

            if (xi > xf) {

                xT = xf + Math.abs(xf - xi) / 2;
                yT = yf + Math.abs(xi - xf) / 2;
            } else {

                xT = xf - Math.abs(xf - xi) / 2;
                yT = yf - Math.abs(xi - xf) / 2;
            }

        }
    }

    public void moveShape(int x1, int y1, int x2, int y2) {
        Shape sMove = shapesInArea.get(index);

        sMove.setX1(xi + (x2 - x1));
        sMove.setY1(yi + (y2 - y1));
        sMove.setX2(xf + (x2 - x1));
        sMove.setY2(yf + (y2 - y1));
        if (sMove instanceof Square || sMove instanceof Circle) {

            sMove.setX2(Math.min(xi, xf) + increaseSide + (x2 - x1));
            sMove.setY2(Math.min(yi, yf) + increaseSide + (y2 - y1));
        } else if (sMove instanceof RightAngledTriangle) {
            RightAngledTriangle tri = (RightAngledTriangle) sMove;
            tri.setX3(tri.getX1());
            tri.setY3(tri.getY2());

        } else if (sMove instanceof Triangle) {
            Triangle tri = (Triangle) sMove;
            tri.setX3(xT + (x2 - x1));
            tri.setY3(yT + (y2 - y1));
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();

        if (action == 'P') {
            Shape s = shapesInArea.get(shapesInArea.size() - 1);
            switch (choice) {
                case 'L': {

                    if (s instanceof Line) {
                        Line l = (Line) s;
                        l.setX2(x2);
                        l.setY2(y2);
                    }
                    repaint();
                    first = false;
                    break;
                }
                case 'R': {
                    if (s instanceof Rectangle) {
                        Rectangle r = (Rectangle) s;
                        r.setX2(x2);
                        r.setY2(y2);

                    }
                    repaint();
                    first = false;
                    break;
                }

                case 'S': {
                    if (s instanceof Square) {
                        Square sq = (Square) s;
                        sq.setX2(x2);
                        sq.setY2(y2);

                    }
                    repaint();
                    first = false;
                    break;
                }
                case 'C': {
                    if (s instanceof Circle) {
                        Circle c = (Circle) s;
                        c.setX2(x2);
                        c.setY2(y2);
                    }
                    repaint();
                    first = false;
                    break;
                }

                case 'O': {
                    if (s instanceof Oval) {
                        Oval o = (Oval) s;
                        o.setX2(x2);
                        o.setY2(y2);
                    }
                    repaint();
                    first = false;
                    break;
                }

                case 'T': {

                    if (s instanceof Triangle) {
                        Triangle t = (Triangle) s;
                        t.setX2(x2);
                        t.setY2(y2);

                        if (x1 > x2) {

                            t.setX3(x2 + Math.abs(x2 - x1) / 2);
                            t.setY3(y2 + Math.abs(x1 - x2) / 2);
                        } else {

                            t.setX3(x2 - Math.abs(x2 - x1) / 2);
                            t.setY3(y2 - Math.abs(x1 - x2) / 2);
                        }

                    }
                    repaint();
                    first = false;
                    break;
                }
                case 'A': {

                    if (s instanceof RightAngledTriangle) {
                        RightAngledTriangle rt = (RightAngledTriangle) s;
                        rt.setX2(x2);
                        rt.setY2(y2);

                        rt.setX3(x1);
                        rt.setY3(y2);

                    }
                    repaint();
                    first = false;
                    break;
                }
            }

            Undo u = new Undo(shapesInArea.size() - 1, 'P', s.getColor(), s.isIsFilled(), s.getX1(), s.getX2(), s.getY1(), s.getY2());
            u.setShape(whichShape(s));
            if (s instanceof Triangle) {

                Triangle t = (Triangle) s;
                u.setX3(t.getX3());
                u.setY3(t.getY3());
            }
            if (s instanceof RightAngledTriangle) {

                RightAngledTriangle rt = (RightAngledTriangle) s;
                u.setX3(rt.getX3());
                u.setY3(rt.getY3());
            }
            unDo.push(u);
            repaint();
        } else if (action == 'M') {
            if (selected) {
                Undo u = new Undo('M', index, x2, x1, y2, y1, increaseSide);
                unDo.push(u);

                moveShape(x1, y1, x2, y2);

                repaint();
                first = false;
            }

        } else if (action == 'Z') {
            if (selected) {
                Undo u = new Undo('Z', index, x2, x1, y2, y1, increaseSide);
                unDo.push(u);

                Shape sMove = shapesInArea.get(index);
                if (sMove instanceof RightAngledTriangle) {
                    RightAngledTriangle rat = (RightAngledTriangle) sMove;
                    rat.setX2(xf + (x2 - x1));
                    rat.setY2(yf);
                    rat.setX1(xi);
                    rat.setY1(yi + (y2 - y1));
                } else {
                    sMove.setX2(xf + (x2 - x1));
                    sMove.setY2(yf + (y2 - y1));
                    if (sMove instanceof Square || sMove instanceof Circle) {

                        sMove.setX2(Math.min(xi, xf) + increaseSide + (x2 - x1));
                        sMove.setY2(Math.min(yi, yf) + increaseSide + (y2 - y1));

                    } else if (sMove instanceof Triangle) {

                        Triangle tri = (Triangle) sMove;
                        tri.setX1(xi + (x2 - x1));
                        tri.setY1(yi + (y2 - y1));

                    }

                }
                repaint();
                first = false;
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e
    ) {

    }

}
