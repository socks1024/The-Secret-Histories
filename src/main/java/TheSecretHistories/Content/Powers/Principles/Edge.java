package TheSecretHistories.Content.Powers.Principles;

import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class Edge extends AbstractPrinciple{

    public static final String POWER_ID = StringUtils.MakeID(Edge.class.getSimpleName());
    private static final String IMG_NAME = "edge";

    public Edge(AbstractCreature owner, int amount){
        super(POWER_ID, IMG_NAME, owner, amount);
    }
}
