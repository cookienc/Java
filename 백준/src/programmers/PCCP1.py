def solution(bandage, health, attacks):
    t, x, y = bandage
    maxHealth = health
    idx = 0
    continueSuccess = 0
    maxIdx = len(attacks)
    for time in range(1, attacks[-1][0] + 1):
        attackTime, damage = attacks[idx]
        if maxIdx > idx and time == attackTime:
            health -= damage
            continueSuccess = 0
            idx += 1

            if health < 0:
                return -1
            continue

        if health < maxHealth:
            health += x
            if health >= maxHealth:
                health = maxHealth
            continueSuccess += 1

        if continueSuccess == t:
            health += y
            if health >= maxHealth:
                health = maxHealth
            continueSuccess = 0
    return health if health > 0 else -1

print(solution([1, 1, 1], 1, [[1, 10], [9, 15], [10, 5], [11, 5]]))
