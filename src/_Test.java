/** Эта программа предназначена для организации логики теста
памяти пользователя на основании задания
@author Maksimov Roman
@version 1.0.0. */
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import java.util.*;

public class TestTest
{
	public static void main(String[] args)
	{
		Test t = new Test( new long {1, 2, 4}, "Medium");
		t.setTrueAnswer();
	}
}
class Test
{
	public Test(long[] t, String l)
	{	
		task = t;
		level = l;
		setTrueAnswer();
		setFalseAnswer();
	}
	public void setTrueAnswer()
	{
		System.out.print(optionNumber());
	}
	public int optionNumber()
	{
		if(level =="Higth") return 15;
		else if(level = "Medium") return 10;
		return 5;
	}
	
	long [] test= new long[optionNumber()];
}