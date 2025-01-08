//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function template for C++

class Solution {
public:
    void helper(vector<vector<int>> &mat, int r, int c, string path, vector<string> &ans) {
        int n = mat.size();
        // Base cases for invalid paths
        if (r < 0 || c < 0 || r >= n || c >= n || mat[r][c] == 0 || mat[r][c] == -1) {
            return;
        }
        // If the destination is reached, add the path to the result
        if (r == n - 1 && c == n - 1) {
            ans.push_back(path);
            return;
        }
        // Mark the current cell as visited
        mat[r][c] = -1;

        // Explore all four possible directions
        helper(mat, r + 1, c, path + "D", ans); // Down
        helper(mat, r - 1, c, path + "U", ans); // Up
        helper(mat, r, c - 1, path + "L", ans); // Left
        helper(mat, r, c + 1, path + "R", ans); // Right

        // Unmark the current cell (backtracking)
        mat[r][c] = 1;
    }

    vector<string> findPath(vector<vector<int>> &mat) {
        int n = mat.size();
        vector<string> ans;
        if (n == 0 || mat[0][0] == 0 || mat[n - 1][n - 1] == 0) {
            return ans; // No path possible if start or end cell is blocked
        }
        string path = "";
        helper(mat, 0, 0, path, ans);
        return ans;
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        string input;
        getline(cin, input);
        vector<vector<int>> mat;
        string innerArray;
        bool isInsideArray = false;

        for (char c : input) {
            if (c == '[') {
                if (isInsideArray) {
                    innerArray.clear();
                }
                isInsideArray = true;
            } else if (c == ']') {
                if (isInsideArray && !innerArray.empty()) {
                    vector<int> row;
                    stringstream ss(innerArray);
                    int num;

                    while (ss >> num) {
                        row.push_back(num);
                        if (ss.peek() == ',')
                            ss.ignore();
                        while (isspace(ss.peek()))
                            ss.ignore();
                    }

                    mat.push_back(row);
                    innerArray.clear();
                }
                isInsideArray = false;
            } else if (isInsideArray) {
                if (!isspace(c)) {
                    innerArray += c;
                }
            }
        }

        Solution obj;
        vector<string> result = obj.findPath(mat);
        sort(result.begin(), result.end());

        if (result.empty())
            cout << "[]";
        else
            for (int i = 0; i < result.size(); i++)
                cout << result[i] << " ";
        cout << endl;
        cout << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends