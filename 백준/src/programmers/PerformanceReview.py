def solution(scores):
    me, scores = scores[0], scores[1:]
    myAttitude, myPeerReivew = me

    scores.sort(key=lambda x: (-x[0], x[1]))
    rank = 1
    threadshold = 0
    for attitude, peerReview in scores:
        if myAttitude < attitude and myPeerReivew < peerReview:
            return -1

        if threadshold <= peerReview:
            threadshold = peerReview

            if myAttitude + myPeerReivew < attitude + peerReview:
                rank += 1

    return rank


print(solution([[2, 2], [1, 4], [3, 2], [3, 2], [2, 1]]))
print(solution([[7, 1], [6, 6], [5, 4], [5, 4], [6, 6]]))
print(solution([[3, 3], [3, 3], [5, 2]]))
print(solution([[3, 3]]))
print(solution([[1, 1], [1, 1], [1, 1], [1, 1], [1, 1]]))
print(solution([[3, 1], [1, 4], [2, 3], [2, 3], [1, 5], [1, 0], [1, 0]]))
