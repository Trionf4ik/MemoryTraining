/** Эта программа предназначена для организации логики теста
памяти пользователя на основании задания
@author Maksimov Roman
@version 1.2.1. */

import java.util.*;
/** Тестирование модуля */
public class TestTest
{
	public static void main(String[] args)
	{
		long[] task = {10234, 45674, 90324};
		Test t = new Test(task, "Hight");
		t = new Test(new Task());
	}
}
class Test
{
/** Конструктор класса тест с простыми входными параметрами
@param t - масив правильных чисел для запоминания
@param l - уровень сложности
*/
	public Test(long[] t, String l)
	{	
		task = t;
		level = l;
		testLength = optionNumber();
		test= new Answer[testLength];
		answerGenerator();
//вывод в консоль содержимого всех вариантов ответов !!!Только для Тестирования!!!
		printTest();
	}
/** Конструктор класса тест с входным параметром объектом Task(Задание)
уровень сложности задается по умолчанию Medium - средний */
	public Test(Task t)
	{ 
		this(t.getPointNumber(), "Medium");
	}
/** заполняет масив test вариантами ответов типа Answer*/
	public void answerGenerator()
	{	
		for(int i=0; i<testLength; i++)
		{
			test[i]=nextAnswer(i);
		}
	}
/** Метод для вывода в консоль содержимое масива test */
	public void printTest()
	{	
		for(int i=0; i<testLength; i++)
		{
			System.out.println(i+") "+test[i].getNumber()+" "+test[i].getBooleanNumber());

		}
		System.out.println(" TestLength:"+test.length);
	}
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
/** Возвращает ответы масивом объектов Answer*/
	public Answer[] getAnsvwer()
	{
		return test;
	}
	
	private int testLength;
	private Answer [] test;
	private long[] task;
	private String level;
	private int counter=0;
	private int counterMax=3;
}
/** Специальный класс созданный для хранения пар: вариант ответа и правильный/неправильный */
class Answer
	{
/** Конструктор класса 
@param  n - вариант числа
@param  b - отвечает на вопрос "Правильный ли ответ?"(true||false)*/
		public Answer(long n, boolean b)
		{
			number = n;
			booleanNumber = b;
		}
/** Конструктор класса по умолчанию */
		public Answer()
		{
		this(0, false);
		}
/** Метод изменяющий все поля объекта класса Answer на 
@param  n - вариант числа
@param  b - отвечает на вопрос "Правильный ли ответ?"(true||false)*/
		public void setAll(long n, boolean b)
		{
		number = n;
		booleanNumber = b;
		}
/** Метод возвращающий значение числа объекта Answer*/
		public long getNumber()
		{	
			return number;
		}
/** Метод возвращающий ответ на вопрос "Правильный ли ответ?"(true||false) объекта Answer*/
		public boolean getBooleanNumber()
		{
			return booleanNumber;
		}
		
		private long number; 
		private boolean booleanNumber;
	}