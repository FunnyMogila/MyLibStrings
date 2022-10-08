package org.example;

public class MyStringLibrary
{
    private char[] string;

    public MyStringLibrary()						// нет конструктора arg, нет строки для создания
    {
        string = null;
    }

    public MyStringLibrary(String s)				// скопируйте каждый символ s в элемент массива
    {
        string = new char[s.length()];
        for(int i=0;i<s.length();i++)
            string[i] = s.charAt(i);
    }

    public MyStringLibrary(char[] c)				// скопируйте каждый символ в строку
    {
        string = new char[c.length];
        for(int i=0;i<c.length;i++)
            string[i] = c[i];
    }

    public String toString()				// создайте строку temp, которая будет представлять собой каждый символ строки, добавленный к ней
    {
        String temp = "";
        for(int i=0; i<string.length; i++)
            temp += string[i];
        return temp;
    }

    public String toUpperCase()				// как toString, но в верхнем регистре любой символ, который является буквой, перед добавлением его во temp
    {
        String temp="";
        for(int i=0;i<string.length;i++)
            temp += Character.toUpperCase(string[i]);
        return temp;
    }

    public String toLowerCase()				// как toString, но в нижнем регистре любой символ, который является буквой, перед добавлением его во temp
    {
        String temp="";
        for(int i=0;i<string.length;i++)
            temp+=Character.toLowerCase(string[i]);
        return temp;
    }

    public String replace(char a, char b)	// как toString, но перед добавлением каждого символа строки в temp, если он равен a, измените его на b
    {
        String temp="";
        for(int i=0;i<string.length;i++)
            if(string[i]==a) temp+=b;
            else temp+=string[i];
        return temp;
    }

    public int length()						// наш массив string содержит 1 символ на символ в строке, поэтому возвращает длину строки
    {
        return string.length;
    }

    public String[] split()					// используйте ' ' в качестве разделителя
    {											// чтобы использовать другой разделитель, напишите метод, который принимает символ c и проверяет a char, c, и затестите if(string[i]!=c) вместо if(string[i]!=' ')
        String temp="";						// накапливайте символы текущего слова, пока не достигнете ' '
        String[] strings = new String[100];					// предположим, что нам не понадобится более 100 из них, мы могли бы использовать string.длина / 2 + 1 в качестве нашего ограничивающего фактора
        int count=0;						// используется для индексации в массив strings
        for(int i=0;i<string.length;i++) {
            if (string[i] != ' ')                // пока мы не найдем ' ', добавим текущий символ в temp
                temp += string[i];
            else                            // как только мы найдем ' ', завершите это слово, добавив temp в массив строк, сбросьте temp на "" и увеличьте количество для следующего элемента в массиве строк
            {
                strings[count] = temp;
                count++;
                temp = "";
            }
        }
        strings[count] = temp;
        count++;
        String[] strings2 = new String[count];		// создайте массив, размер которого равен количеству различных строк, найденных в нашей строке
        for(int i=0;i<count;i++)					// скопируйте каждую строку в новый массив
            strings2[i] = strings[i];
        return strings2;					// возвращаем уменьшенный массив
    }

    public static String join(String s1, String s2)
    {
        return s1 + s2;
    }

    public boolean equalsIgnoreCase(String s)
    {
        char[] string2 = s.toCharArray();

        if (string.length != string2.length)
        {
            return false;
        }

        char[] tempString = new char[string.length];
        char[] tempString2 = new char[string2.length];
        for (int i = 0; i < string.length; i++)
        {
            tempString[i] = Character.toLowerCase(string[i]);
            tempString2[i] = Character.toLowerCase(string2[i]);
            if (tempString[i] != tempString2[i])
            {
                return false;
            }
        }
        return true;
    }

    public static String format(String s, int d)
    {
        boolean isFind = false;
        int counter = 0;
        char[] string2 = s.toCharArray();
        for (int i = 0; i < string2.length; i++)
        {
            if (string2[i] == '%')
            {
                if ((i + 1) != string2.length)
                {
                    if (string2[i + 1] == 'd')
                    {
                        string2[i] = (char) (d + '0');
                        isFind = true;
                        counter = i;
                        break;
                    }
                }
            }
        }
        if (isFind)
        {
            for (int i = counter + 1; i < string2.length - 1; i++)
            {
                string2[i] = string2[i + 1];
            }
            String temp = "";
            for(int i = 0; i < string2.length - 1; i++)
                temp += string2[i];
            return temp;
        }
        else
        {
            return s;
        }
    }

    public int indexOf(char ch) {
        for (int i = 0; i < string.length; i++) {
            if (string[i] == ch) {
                return i;
            }
        }
        return -1;
    }
}
