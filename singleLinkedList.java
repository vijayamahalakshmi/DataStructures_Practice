package linkedListPractice;

import java.util.Scanner;

// Node class for the linked list
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Singly Linked List implementation
public class singleLinkedList {
    Node head;

    // Method to add a node at the end of the linked list
    public void addNode(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Method to insert a node at the beginning of the linked list
    public void insertAtFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Method to insert a node at the end of the linked list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode; // If the list is empty, set head to the new node
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next; // Traverse to the last node
            }
            temp.next = newNode; // Link the new node at the end
        }
    }

    // Method to insert a node at a specific position
    public void specified(int data, int position) {
        if (position <= 0) {
            System.out.println("Position should be greater than 0.");
            return;
        }

        Node newNode = new Node(data);

        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    // Method to delete a node at the beginning of the linked list
    public void deleteNodeAtFirst() {
        if (head == null) {
            System.out.println("LinkedList is empty");
        } else {
            head = head.next; // Move the head pointer to the next node
        }
    }

    // Method to delete a node at the end of the linked list
    public void deleteNodeAtEnd() {
        if (head == null) {
            System.out.println("LinkedList is empty.");
        } else if (head.next == null) {
            head = null; // Only one node in the list
        } else {
            Node temp = head;
            while (temp.next.next != null) { // Traverse to the second last node
                temp = temp.next;
            }
            temp.next = null; // Remove the last node
        }
    }

    // Method to delete a node at a specific position
    public void deleteAtSpecifiedPos(int pos) {
        if (pos <= 0) {
            System.out.println("Position should be greater than 0.");
            return;
        }

        if (head == null) {
            System.out.println("LinkedList is empty.");
            return;
        }

        // If deleting the first node
        if (pos == 1) {
            head = head.next;
            return;
        }

        Node current = head;
        Node prev = null;

        // Traverse to the node before the specified position
        for (int i = 1; i < pos && current != null; i++) {
            prev = current;
            current = current.next;
        }

        // If the position is out of bounds
        if (current == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        // Unlink the node
        prev.next = current.next;
    }
    //sorted insert
    
    public void sortedInsert(int data) {
        Node newNode = new Node(data);

        // Special case: If the list is empty or the new data is smaller than the head node
        if (head == null || head.data >= newNode.data) {
            newNode.next = head;
            head = newNode;
        } else {
            // Traverse the list to find the correct insertion point
            Node current = head;

            while (current.next != null && current.next.data < newNode.data) {
                current = current.next;
            }

            // Insert the new node in its sorted position
            newNode.next = current.next;
            current.next = newNode;
        }
    }


	
    // Method to display the linked list
    public void display() {
        if (head == null) {
            System.out.println("Linked list is empty.");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method for user interaction
    public static void main(String[] args) {
        singleLinkedList list = new singleLinkedList();
        Scanner scanner = new Scanner(System.in);

        // Add nodes to the linked list
        System.out.print("Enter the number of nodes you want to add: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter data for node " + (i + 1) + ": ");
            int data = scanner.nextInt();
            list.addNode(data);
        }

        // Display the linked list
        System.out.println("Linked List after adding nodes:");
        list.display();

        // Insert a node at the beginning
        System.out.print("Enter data to insert at the beginning: ");
        int dataAtFirst = scanner.nextInt();
        list.insertAtFirst(dataAtFirst);
        System.out.println("After inserting at the beginning:");
        list.display();

        // Insert a node at the end
        System.out.print("Enter data to insert at the end: ");
        int dataAtEnd = scanner.nextInt();
        list.insertAtEnd(dataAtEnd);
        System.out.println("After inserting at the end:");
        list.display();

        // Insert a node at a specified position
        System.out.print("Enter the position to insert: ");
        int pos = scanner.nextInt();
        System.out.print("Enter data for the new node: ");
        int dataAtPos = scanner.nextInt();
        list.specified(dataAtPos, pos);
        System.out.println("After inserting " + dataAtPos + " at position " + pos + ":");
        list.display();

        // Delete the first node
        System.out.println("Deleting the first node...");
        list.deleteNodeAtFirst();
        list.display();

        // Delete the last node
        System.out.println("Deleting the last node...");
        list.deleteNodeAtEnd();
        list.display();

        // Delete a node at a specified position
        System.out.print("Enter the position to delete: ");
        int deletePos = scanner.nextInt();
        list.deleteAtSpecifiedPos(deletePos);
        list.display();
        System.out.print("Enter the you want to insert in sorted insert");
        int sortedins = scanner.nextInt();
        list.sortedInsert(sortedins);
        System.out.println("Ater adding another node");
        list.display();
        

        scanner.close(); // Close the scanner to prevent resource leaks
    }
}
