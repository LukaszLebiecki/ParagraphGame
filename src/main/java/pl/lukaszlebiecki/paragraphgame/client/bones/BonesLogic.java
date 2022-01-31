package pl.lukaszlebiecki.paragraphgame.client.bones;

import java.util.Random;

public class BonesLogic {
    private Random random = new Random();

    public void k100Random(Bones bones) {
        bones.setK100(random.nextInt(100) + 1);
    }

    public void k61Random(Bones bones) {
        bones.setK6_1(random.nextInt(6) + 1);
    }

    public void k62Random(Bones bones) {
        bones.setK6_2(random.nextInt(6) + 1);
    }

    public void k63Random(Bones bones) {
        bones.setK6_3(random.nextInt(6) + 1);
    }

    public void k4Random(Bones bones) {
        bones.setK4(random.nextInt(4) + 1);
    }

    public void k3Random(Bones bones) {
        bones.setK3(random.nextInt(3) + 1);
    }

    public void k2Random(Bones bones) {
        bones.setK2(random.nextInt(2) + 1);
    }

}
