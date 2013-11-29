/** 
This class generate task for program MemoryTraining
this is thirteen step to program
@author Maksimov Roman
@version 1.3.1
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
		Task t = new Task(i+1, i);
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
@param digit - количество цифр в задании
@param num - количество елементов в задании
@param pointNumber - масив из элементов заданий для запоминания */ 
	public Task(int n, int d)
	{	
		setId(); 
		digit = d;
		int num = n;
		pointNumber = generateNumber(num, d);
	}
	public Task(int n)
	{	
		this(n, 5);
	}
	public Task()
	{
		this(5, 5);
	}
/** Задает каждому заданию порядковый номер следующий по счету */
	public void setId()
	{
		id = nextId;
		nextId++;
	}
/** Метод начинает нумерацию заданий с единицы */
	public static void zeroing()
	{
		nextId = 1;
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
@param n - количество елементов для запоминания
@param d - количество цифр в каждом елементе
@return масив чисел */
	public long[] generateNumber(int n, int d)
	{
		long [] tempArray = new long[n];
		for(int i=0; i<n; i++)
		{
			TaskPoint t = new TaskPoint(d);
			tempArray[i] = t.getNumber();
		}
		return tempArray;
	}
	private int digit; // количество цифр в задании
	private static int nextId = 1;
	private int id;
	private int num; //количество елементов в задании
	private long [] pointNumber;
}
class TaskPoint
{
/**  Конструктор класса создающего елемент запоминания
@param number - число для запоминания
@param d - количество цифр в елементе задания
 */ 
	public TaskPoint(int d)
	{
		digit = d;
		number = randomNumber(digit);
	}
	public TaskPoint()
	{
		this(5);
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