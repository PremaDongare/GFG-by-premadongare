<h2><a href="https://www.geeksforgeeks.org/problems/parenthesis-checker2744/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card">Parenthesis Checker</a></h2><h3>Difficulty Level : Difficulty: Easy</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">Given a string s, composed of different combinations of '(' , ')', '{', '}', '[', ']', verify the validity of the arrangement.<br></span><span style="font-size: 18px;">An input string is valid if:</span></p>
<p><span style="font-size: 18px;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;1. Open brackets must be closed by the same type of brackets.<br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;2. Open brackets must be closed in the correct order.</span></p>
<p><strong><span style="font-size: 18px;">Examples :</span></strong></p>
<pre><span style="font-size: 18px;"><strong>Input: </strong>s = "[{()}]"
<strong>Output:</strong> true
<strong>Explanation: </strong>All the brackets are well-formed.</span></pre>
<pre><span style="font-size: 18px;"><strong>Input: </strong>s = "[()()]{}"
<strong>Output:</strong> true
<strong>Explanation: </strong>All the brackets are well-formed.<br></span></pre>
<pre><strong><span style="font-size: 18px;">Input:</span></strong><span style="font-size: 18px;"> s = "([]"<br><strong>Output: </strong>False<br><strong>Explanation: </strong>The expression is not balanced as there is a missing ')' at the end.<br></span></pre>
<pre><strong><span style="font-size: 18px;">Input:</span></strong><span style="font-size: 18px;"> s = "([{]})"<br><strong>Output: </strong>False<br><strong>Explanation: </strong>The expression is not balanced as there is a closing ']' before the closing '}'.<br></span></pre>
<p><span style="font-size: 14pt;"><strong>Constraints:</strong><br>1 ≤ s.size() ≤ 10<sup>6<br></sup>s[i] ∈ {'{', '}', '(', ')', '[', ']'}</span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Flipkart</code>&nbsp;<code>Amazon</code>&nbsp;<code>Microsoft</code>&nbsp;<code>OYO Rooms</code>&nbsp;<code>Snapdeal</code>&nbsp;<code>Oracle</code>&nbsp;<code>Walmart</code>&nbsp;<code>Adobe</code>&nbsp;<code>Google</code>&nbsp;<code>Yatra.com</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Strings</code>&nbsp;<code>Stack</code>&nbsp;<code>STL</code>&nbsp;<code>Data Structures</code>&nbsp;