package TheSecretHistories.Content.Cards.FITIF.Fragments;

import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.FORGE;

public class FragmentForge extends AbstractFragment{

    public static String ID = StringUtils.MakeID(FragmentForge.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = FORGE;

    public FragmentForge() {
        super(ID, PRINCIPLE_TAG);

        this.magicNumber = this.baseMagicNumber = 1;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        super.use(abstractPlayer, abstractMonster);

        addToBot(new ExhaustAction(magicNumber, true));
    }
}
