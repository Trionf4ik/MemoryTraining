/** Эта программа предназначена для организации логики теста
памяти пользователя на основании задания
@author Maksimov Roman
@version 1.2.2. */

import java.util.*;
/** Тестирование модуля */
public class TestTest
{
	public static void main(String[] args)
	{
		long[] task = {10234, 45674, 90324};
		Test t = new Test(task, "Hight");
		t = new Test(new Task());
		t.setBalls(100);
		Result r = new Result();
		r.update(t);
		
		
	//Для тестування модуля в консоли
	//	t.printTest();
	}
}
class Test
{
/** Конструктор класса тест с простыми входными параметрами
@param t - масив правильных чисел для запоминания 
@param l - уровень сложности
@param balls - количество балов за данный тест
@param id - номер задания по которому создан тест
@param testLength - количество елементов для запоминания в задании (зависит от уровня сложности)
@param counterMax - максимальное количество правильных ответов 
*/
	public Test(long[] t, String l)
	{	
		task = t;
		counterMax = t.length;
		id = 1;
		level = l;
		balls = 0;
		testLength = optionNumber();
		test= new Answer[testLength];
		answerGenerator();
//вывод в консоль содержимого всех вариантов ответов !!!Только для Тестирования!!!
//		printTest();
	}
/** Конструктор класса тест с входным параметром объектом Task(Задание)
уровень сложности задается по умолчанию Medium - средний */
	public Test(Task t)
	{ 
		this(t.getPointNumber(), "Medium");
		id=t.getId();
	}
	
/** Возвращает количество всех ответов в задании*/	
	public int getTestLength()
	{ return testLength;}
/** Возвращает номер задания*/
	public int getId()
	{return id;}
/** заполняет масив test вариантами ответов типа Answer*/
	public void answerGenerator()
	{	
		for(int i=0; i<testLength; i++)
		{
			test[i]=nextAnswer(i);
		}
	}
/** Метод для вывода в консоль содержимое масива test  Предназначен только для тестирования*/
/*
	public void printTest()
	{	
		for(int i=0; i<testLength; i++)
		{
			System.out.println(i+") "+test[i].getNumber()+" "+test[i].getBooleanNumber());

		}
		System.out.println(" TestLength: "+test.length);
		System.out.println("Balls: "+balls);
	}
	*/
/** Равновероятно coздает правильный или неправильный ответ в виде объекта Answer
Правильные объекты выводит только один раз загоняя их в конец масива и уменьшая на 1 длину перебора правильных значений
@param i - порядковый номер счетчика, который используется для выборки правильных значений*/
	public Answer nextAnswer (int i)
	{
		counter = i;
		Answer tempAnswer = new Answer(falseNumber(5), false);
		if (counterMax>0) 
		{
			while (counter>=counterMax) counter -= counterMax;
			if(Math.random()>0.49) 
			{
			long temp = task[counter];
			task[counter] =task[counterMax-1];
			task[counterMax-1] = temp;
			counterMax --;
			tempAnswer.setAll(temp, true);
			return tempAnswer;
			}
		}
		return tempAnswer;	
	}
/** Генерирует случайное число
@param digitSet - количество цифр в генерируемом числе*/
	public long falseNumber(int digitSet)
	{
		long temp =0;
		for(int i=1; i<=digitSet; i++)
		{
			temp+=(long)Math.pow(10, i)*Math.random();
		}
		return temp;
	}
/** Задает количество вариантов ответа в зависимости от уровня сложности*/
	public int optionNumber()
	{
		if(level =="Hight") return 20;
		else if(level == "Medium") return 15;
		return 10;
	}
/** Возвращает масив вариантов ответов*/
	public Answer[] getAnswer()
	{
		return test;
	}
/** Задает масив вариантов ответов*/
	public void setAnswer(Answer[] userChange)
	{
		if (test.length!=userChange.length)
		{
		System.out.println("Wrong length array! ATTENTION!");
		}
		else
		{
		System.arraycopy(userChange, 0, test, 0, test.length);
		}
	}
/** Метод задает количество балов за тест*/
	public void setBalls(int b)
	{
		balls = b;
	}
/** Метод возвращает количество балов за тест*/
	public int getBalls()
	{
		return balls;
	}
/** Метод возвращает уровень сложности теста*/
	public String getLevel()
	{
		return level;
	}
	private int id;
	private int testLength;
	private Answer [] test;
	private long[] task;
	private String level;
	private int counter=0;
	private int counterMax=3;
	private int balls;
}