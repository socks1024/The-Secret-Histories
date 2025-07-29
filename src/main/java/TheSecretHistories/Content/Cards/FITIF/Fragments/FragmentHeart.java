package TheSecretHistories.Content.Cards.FITIF.Fragments;

import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.LoseDexterityPower;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.HEART;

public class FragmentHeart extends AbstractFragment{

    public static String ID = StringUtils.MakeID(FragmentHeart.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = HEART;

    public FragmentHeart() {
        super(ID, PRINCIPLE_TAG);

        this.block = this.baseBlock = 2;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        super.OnUpgrade(timesUpgraded);
        upgradeBlock(2);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        super.use(abstractPlayer, abstractMonster);

        addToBot(new GainBlockAction(abstractPlayer, block));
    }
}
