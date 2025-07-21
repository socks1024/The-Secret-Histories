package TheSecretHistories.Content.Cards.FITIF.Fragments;

import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.LoseStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.EDGE;

public class FragmentEdge extends AbstractFragment{

    public static String ID = StringUtils.MakeID(FragmentEdge.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = EDGE;

    public FragmentEdge() {
        super(ID, PRINCIPLE_TAG);
        this.magicNumber = this.baseMagicNumber = 2;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        super.use(abstractPlayer, abstractMonster);

        addToBot(new ApplyPowerAction(abstractPlayer, abstractPlayer, new StrengthPower(abstractPlayer, magicNumber)));
        addToBot(new ApplyPowerAction(abstractPlayer, abstractPlayer, new LoseStrengthPower(abstractPlayer, magicNumber)));
    }
}
