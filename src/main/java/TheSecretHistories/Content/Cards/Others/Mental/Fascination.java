package TheSecretHistories.Content.Cards.Others.Mental;

import TheSecretHistories.Content.Cards.Others.TemplateCustomStatusCard;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Fascination extends TemplateCustomStatusCard {

    public static final String ID = StringUtils.MakeID(Fascination.class.getSimpleName());

    private static final String IMG_NAME = "fascination";

    public Fascination() {
        super(ID, IMG_NAME);
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {

    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {

    }
}
