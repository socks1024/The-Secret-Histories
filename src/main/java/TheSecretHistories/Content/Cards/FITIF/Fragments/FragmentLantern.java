package TheSecretHistories.Content.Cards.FITIF.Fragments;

import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.LANTERN;

public class FragmentLantern extends AbstractFragment {

    public static String ID = StringUtils.MakeID(FragmentLantern.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = LANTERN;

    public FragmentLantern() {
        super(ID, PRINCIPLE_TAG);

        this.magicNumber = this.baseMagicNumber = 1;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        super.OnUpgrade(timesUpgraded);

        if (timesUpgraded == 3) upgradeMagicNumber(1);

        if (timesUpgraded == 6) upgradeMagicNumber(1);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        super.use(abstractPlayer, abstractMonster);

        addToBot(new DrawCardAction(magicNumber));
    }
}
