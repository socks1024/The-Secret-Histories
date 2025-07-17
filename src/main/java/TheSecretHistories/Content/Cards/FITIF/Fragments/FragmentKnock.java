package TheSecretHistories.Content.Cards.FITIF.Fragments;

import TheSecretHistories.Utils.DeckUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.defect.DiscardPileToHandAction;
import com.megacrit.cardcrawl.actions.utility.DiscardToHandAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.KNOCK;

public class FragmentKnock extends AbstractFragment{

    public static String ID = StringUtils.MakeID(FragmentKnock.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = KNOCK;

    public FragmentKnock() {
        super(ID, PRINCIPLE_TAG);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        super.use(abstractPlayer, abstractMonster);

        addToBot(new DiscardToHandAction(DeckUtils.GetMansusCard()));
    }
}
