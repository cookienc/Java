import copy
import sys

input = sys.stdin.readline

op = ('+', '-', '*', '/')

def dfs(target, operands, depth, sum):
    global nums
    global maxAnswer
    global minAnswer

    if depth == len(nums):
        maxAnswer = max(sum, maxAnswer)
        minAnswer = min(sum, minAnswer)
        return

    for i in range(4):
        if operands[i] == 0:
            continue

        deepcopy = copy.deepcopy(operands)
        deepcopy[i] -= 1
        cur_op = op[i]
        if cur_op == '+':
            dfs(target, deepcopy, depth + 1, sum + target[depth])
        if cur_op == '-':
            dfs(target, deepcopy, depth + 1, sum - target[depth])
        if cur_op == '*':
            dfs(target, deepcopy, depth + 1, sum * target[depth])
        if cur_op == '/':
            dfs(target, deepcopy, depth + 1, int(sum / target[depth]))


N = int(input())
nums = list(map(int, input().split()))
operands = list(map(int, input().split()))

maxAnswer = -sys.maxsize
minAnswer = sys.maxsize
dfs(nums, operands, 1, nums[0])

print(maxAnswer)
print(minAnswer)
