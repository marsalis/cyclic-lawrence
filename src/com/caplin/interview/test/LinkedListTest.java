package com.caplin.interview.test;

public class LinkedListTest
{
	private LinkedList<Long> list = new LinkedList<Long>();

	public static void main(String[] args)
	{
		new LinkedListTest();
	}

	public LinkedListTest()
	{
		createList();
		testList();
	}

	private void testList()
	{
		LinkedListElement<Long> first = list.head;
		LinkedListElement<Long> second = list.head;

		while (true)
		{
			first = first.next;
			second = second.next.next;

			System.out.println("First  [" + first.value + "]");
			System.out.println("Second [" + second.value + "]\n");

			if (second == null || second.next == null)
			{
				System.out.println("Acyclic!");
				return;
			}
			else if (first == second || first == second.next)
			{
				System.out.println("Cyclic!");
				return;
			}
		}
	}

	private void createList()
	{
		LinkedListElement<Long> currentElement = new LinkedListElement<Long>();
		list.head = currentElement;

		for (long i = 0; i < 1000; i++)
		{
			LinkedListElement<Long> nextElement = new LinkedListElement<Long>();
			currentElement.next = nextElement;
			currentElement.value = i;
			currentElement = nextElement;
		}

		currentElement.next = list.head;
	}

	private static class LinkedList<T>
	{
		public LinkedListElement<T> head;
	}

	private static class LinkedListElement<T>
	{
		public T value;
		public LinkedListElement<T> next;
	}
}
