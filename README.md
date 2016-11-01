# Android Async Sort Test
Cancellable Collection sorting for Android AsyncTask

Intro:

Import the project in Android Studio.

It may ask to download the Gradle wrapper, which you should probably do.

Run the application in an Android emulator or on an Android device.

Go in the NavigationView and tap on Async Sort item.

It shows a new Activity with a simple ListView with mocked data.

Each item in the list is supposed to represent a message: the name of the sender, the subject of the message, the time the message was received.

Messages are initially displayed in the order they were created, so the time increases as you scroll down the list.

The “Sort” button should change the order messages are displayed in the list. They should be displayed in reverse chronological order, then alphabetically by sender, then alphabetically by subject.

If you click on Sort, the Button will become a “Cancel” button. After several seconds (less than 1 minute on a decent computer), sorting will finish and you will notice that the order of the item has not changed.

Tasks:

1) Your first task is to make sorting work.

Read mimecast.com.recruitment.task.EmailHeaderListReverseChronologicalSortTask

You will find a java.util.Comparator that defines the order we want after sorting.

In order to make sorting work correctly, all you have to do is implement mimecast.com.recruitment.utils.CancellableCollectionOperations.swap().

You can then run the application again and check that your implementation is working.

However, if you click on “Cancel” while sorting, you will notice that the operation still takes just as much time as sorting.

2) Your second task is to allow sorting to be cancelled

Notice that CancellableCollectionOperations.recursiveQuickSort() is a simple implementation of https://en.wikipedia.org/wiki/Quicksort and is called from EmailHeaderListReverseChronologicalSortTask.doInBackground().

You should implement CancellableCollectionOperations.cancellableRecursiveQuickSort()

Update the Quicksort implementation so that it regularly checks whether the android.os.AsyncTask has been cancelled.

When you’re done, run the application. Click Sort. Click Cancel. You should be able to click on Sort again very quickly, without having to wait several seconds for the Button to be visible again.

If sorting is cancelled, the ListView can display the items without any order.


3) Your third task is implement an iterative version of the sorting algorithm

The basic implementation of Quicksort is recursive.

Unfortunately, we may want to sort hundreds or thousands of items even on a mobile phone.

Therefore, we want to de-recurse the sorting algorithm.

You should implement CancellableCollectionOperations.iterativeQuickSort()

Notice that it doesn’t need to be cancellable, which will change the User Experience of the application.

4) Finally, send us your CancellableCollectionOperations.java file for review.

Background for this exercise can be found at http://stackoverflow.com/questions/25429263/android-cancellable-java-collection-sort-in-asynctask-doinbackground



# Android String Replacement Test
Atomically replace multiple strings at once

Intro:

Import the project in Android Studio.

It may ask to download the Gradle wrapper, which you should probably do.

Run the application in an Android emulator or on an Android device.

Go in the NavigationView and tap on String Replacement item.

It shows a new Activity with some EditText and a button "Replace".

The first edittext “Source” is to insert the source string

The second edittext “Target" is to insert the targets or patterns, to search for within the source string. Please use Comma (,) to specify different targets, don’t use spaces before and after Comma(,)

The third ediitext “Replacement” is to insert the replacements strings used to replace occurances of targets at the same index. Please use Comma (,) to specify different targets, don’t use spaces before and after Comma(,)

The button "Replace" doesn't do anything, so the goal of the test is to give the result pressing the button. You have to show the result using the TextView below the button. There is no text in the TextView for now you can't see it.

Task:

Implements replaceOccurrenceOfStrings(String sourceString, String[] targetArray, String[] replacementArray) menthod in StringReplacementActivity to show the result.

targetArray is an array of strings to search. If there are more targets than replacements then a) if there is only 1 replacement it will be used to replace all target strings. b) extra targets will be ignored. i.e you should ensure that there are the same number of items in each array, OR only have one replacement string if you want to replace all the target strings with the same string.

replacementArray is an array of strings to use to replace occurances of targets at the same index. If there are more replacements than targets, extra replacements will be ignored. If there is only 1 string, it will be used to replace all of the target strings.

When matching targets, this method orders matches by location, then greedily if multiple targets are found at the same location and then by position in the targets array.

Since this is quite a hard method to document, its easier to give a few examples of the replacements that get done.
 
 "abc aabbcc" replacing "a" ==> "b", "b" ==> "c", "c" ==> "a". Gives "bca bbccaa". Contrast this to one-by-one replacement which would give "aaa aaaaaa"!
 
 "abc aabbcc" replacing "a" ==> "b", "b" ==> "c", "c" ==> "a", "bb" ==> "dd". Gives "bca bbddaa". "bb" beats "b" as it is more greedy<br>

 "Dockchair" replacing "chair" ==> "hand", "c" ==> "r". Gives "Dorkhand".

 "Hello you, Goodbye me" replacing "Hello" ==> "Goodbye", "Goodbye" ==> "So long". Gives "Goodbye you, So long me".

 For the test, assume all target strings should only match exact sequences of themselves (e.g case sensitive, diacritic sensitive etc). e.g "Hello" will not match "hello".
