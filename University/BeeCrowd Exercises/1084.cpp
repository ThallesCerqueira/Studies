#include <iostream>
#include <string>
using namespace std;

int main() {
    while (true) {
        int N, D;
        cin >> N >> D;

        if (N == 0 && D == 0) {
            break;
        }

        string number;
        cin >> number;

        string result = "";

        for (char digit : number) {
            while (D > 0 && !result.empty() && result.back() < digit) {
                result.pop_back();
                D--;
            }
            result.push_back(digit);
        }

        while (D > 0) {
            result.pop_back();
            D--;
        }

        // Remove leading zeros
        size_t first_non_zero = result.find_first_not_of('0');
        if (first_non_zero != string::npos) {
            result = result.substr(first_non_zero);
        } else {
            result = "0";
        }

        cout << result << endl;
    }

    return 0;
}