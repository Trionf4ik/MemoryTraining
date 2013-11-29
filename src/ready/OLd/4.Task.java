/** 
This class generate task for program MemoryTraining
this is fourth step to program
@author Maksimov Roman
@version 1.0.1
*/ 

/** Класс отвечающий за генерацию задания для запоминания
@param num - количество елементов в задании
@param id - номер задания
*/
class Task 
{

/** Блок кода отвечающий за тестирование класса*/ 
/** ТЕСТ НАЧАЛО*/ 
	public static void main (String[] args)
	{
		for (int i=1; i<10; i++)
		{
		Task t = new Task();
		long [] array = t.getPointNumber();
		System.out.print("Task #"+t.getId()+" Have digital: ");
		for(long a : array)
		{
			System.out.print(a+"; ");
		}
		System.out.println();		
		}
	}
/** TЕСТ КОНЕЦ*/ 

/**  Конструктор класса 
@param id - номер задания
@param pointNumber - масив из элементов заданий для запоминания */ 
	public Task()
	{
		setId(); 
		int num = 5;
		pointNumber = generateNumber(num);
	}
	
/** Задает каждому заданию уникальный порядковый номер следующий по счету */
	public void setId()
	{
		id = nextId;
		nextId++;
	}
/** Выводит номер задания*/
	public int getId()
	{
		return id;
	}
/** Выводит массив из численных заданий*/
	public long[] getPointNumber()
	{
		return pointNumber;
	}
/** Генерирует задание из массива елементов
@return масив чисел */
	public long[] generateNumber(int num)
	{
		long [] tempArray = new long[num];
		for(int i=0; i<num; i++)
		{
			TaskPoint t = new TaskPoint();
			tempArray[i] = t.getNumber();
		}
		return tempArray;
	}
	private static int nextId = 1;
	private int id;
	private int num; //количество елементов в задании
	private long [] pointNumber;
}
class TaskPoint
{
/**  Конструктор класса создающего елемент запоминания
@param number - число для запоминания
@param digit - количество цифр в елементе задания
 */ 
	public TaskPoint()
	{
		digit = 5;
		number = randomNumber(digit);
	}
/**  Метод генерирует случайное число с количеством цифр digitSet, заданым как параметр */ 
	public long randomNumber(int digitSet)
	{
		long temp =0;
		for(int i=1; i<=digitSet; i++)
		{
			temp+=(long)Math.pow(10, i)*Math.random();
		}
		return temp;
	}
/**  Метод возвращает число елемента задания */ 	
	public long getNumber()
	{
		return number;
	}
	private long number;
	private int digit;
}