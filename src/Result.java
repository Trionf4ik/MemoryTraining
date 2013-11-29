/** Этот модуль предназначена для подсчета количества балов за тестирование
@author Maksimov Roman
@version 1.0.1 */

import java.util.*;
public class Result
{
/** Конструктор класса
@param balls - количество балов которое на данный момент набрал пользователь
за тестирование
@param time - время затраченное пользователем на тестирование
@param percent - процент правильных ответов
@param level - уровень задания
 */
	public Result()
	{
		balls = 0;
		time = 0;
		percent = 0;
		level = "Easy";
	}
	public void update (Test test)
	{
		tempTest = test;
		level = tempTest.getLevel();
		analyse();
	}
	private void analyse()
	{
		Answer[] answer = tempTest.getAnswer();
		int factor = answer.length;
		boolean allAnswerTrue = true;
		int tempBalls = 0;
		for (Answer a: answer)
		{
			boolean system = a.getBooleanNumber();
			boolean user = a.getUserNumber();
			if (system && user)
			{tempBalls+=factor;
			System.out.println("+Factor");}
			else if (user)
			{ 
			allAnswerTrue = false;
			tempBalls-=factor;
			System.out.println("-Factor");
			}
			else if (system)
			{
				allAnswerTrue = false;
			}
		}
		if (allAnswerTrue) 
		{
		tempBalls+=3*factor;
		System.out.println("All True!");
		}
		balls+=tempBalls;
	}
	/** Метод возвращает количество балов за тест*/
	public int getBalls()
	{
		return balls;
	}
/** Метод возвращает время тестирования*/
	public int getTime()
	{
		return time;
	}
	//private Answer [] answer;
	private Test tempTest;
	private int balls;
	private int time;
	private int percent = 0;
	private String level;
	
}
