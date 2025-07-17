package TheSecretHistories.Content.Cards.FITIF.Influences;

import TheSecretHistories.Utils.DeckUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.utility.DiscardToHandAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.KNOCK;

public class InfluenceKnock extends AbstractInfluences {

    public static String ID = StringUtils.MakeID(InfluenceKnock.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = KNOCK;

    public InfluenceKnock() {
        super(ID, PRINCIPLE_TAG);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        super.use(abstractPlayer, abstractMonster);

        addToBot(new DiscardToHandAction(DeckUtils.GetMansusCard()));
    }
}
