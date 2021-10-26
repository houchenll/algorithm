#include <iostream>
#include <algorithm>

using namespace std;

void bubbleSort( int arr[], int n ) {
    for ( int i = 0; i < n; i++ )
        for ( int j = 0; j < n - 1 - i; j++ )
            if ( arr[j] > arr[j + 1] )
                swap( arr[j], arr[j + 1] );
}

int main() {
    int arr[10] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
    bubbleSort( arr, 10 );
    for ( int i = 0; i < 10; i++ )
        cout << arr[i] << " ";
    cout << endl;
    return 0;
}
