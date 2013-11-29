/** Этот класс создает объект Answer в котором хранится число, ответ пользователя, правильный ответ
@author Maksimov Roman
@version 1.2.1. */


/** Специальный класс созданный для хранения пар: вариант ответа и правильный/неправильный */
public final class Answer
	{
/** Конструктор класса 
@param  n - вариант числа
@param  b - отвечает на вопрос "Правильный ли ответ?"(true||false)
@param  userNumber - отмечает ответ пользователя "Считает ли он ответ правильным? (по умолчанию false)"
*/
		public Answer(long n, boolean b)
		{
			number = n;
			booleanNumber = b;
			userNumber = false;
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
/** Метод возвращающий параметра userNumber, который хранит ответ "Считает ли пользователь ответ правильным?*/
		public boolean getUserNumber()
		{
		return userNumber;
		}
/** Метод задает параметр userNumber */
		public void setUserNumber(boolean u)
		{
			userNumber = u;
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
		private boolean userNumber;
		private long number; 
		private boolean booleanNumber;
	}