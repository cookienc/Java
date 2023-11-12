package programmers;

public class DeliveryAndPickUpOfPackages {

    public static void main(String[] args) {
        int cap = 4;
        int n = 4;
        int[] deliveries = new int[]{25,24,51,0};
        int[] pickups = new int[]{51,0,0,49};
        System.out.println(solution(cap, n, deliveries, pickups));
    }

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int dp = -1;
        int pp = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (dp != -1 && pp != -1) {
                break;
            }

            if (dp == -1 && deliveries[i] != 0) {
                dp = i;
            }

            if (pp == -1 && pickups[i] != 0) {
                pp = i;
            }
        }

        if (dp == 0 && pp == 0) {
            return 0;
        }

        long distance = 0;
        while (!(dp <= 0 && pp <= 0 && deliveries[0] == 0 && pickups[0] == 0)) {
            int start = Math.max(dp,pp);
            distance += 2 * (start + 1);

            int capDelivery = 0;
            if (dp <= 0 && deliveries[0] == 0) {
                capDelivery = cap;
            }

            int capPickup = 0;
            if (pp <= 0 && pickups[0] == 0) {
                capPickup = cap;
            }

            for (int i = start; i >= 0; i--) {
                if (capDelivery == cap && capPickup == cap) {
                    break;
                }

                final int curDelivery = deliveries[i];

                if (cap > capDelivery && curDelivery != 0) {
                    final int diff = cap - capDelivery;
                    if (diff >= deliveries[i]) {
                        capDelivery += curDelivery;
                        deliveries[i] = 0;
                    } else {
                        capDelivery = cap;
                        deliveries[i] -= diff;
                    }
                }

                final int curPickup = pickups[i];

                if (cap > capPickup && curPickup != 0) {
                    final int diff = cap - capPickup;
                    if (diff >= pickups[i]) {
                        capPickup += curPickup;
                        pickups[i] = 0;
                    } else {
                        capPickup = cap;
                        pickups[i] -= diff;
                    }
                }
            }

            for (int i = dp; i >= 0; i--) {
                dp = i;
                if (deliveries[i] != 0) {
                    break;
                }
            }

            for (int i = pp; i >= 0; i--) {
                pp = i;
                if (pickups[i] != 0) {
                    break;
                }
            }
        }
        return distance;
    }
}
