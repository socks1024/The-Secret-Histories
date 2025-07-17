package TheSecretHistories.Content.Cards.FITIF.Fragments;

import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.MOTH;

public class FragmentMoth extends AbstractFragment{

    public static String ID = StringUtils.MakeID(FragmentMoth.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = MOTH;

    public FragmentMoth() {
        super(ID, PRINCIPLE_TAG);

        this.block = this.baseBlock = 4;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        super.use(abstractPlayer, abstractMonster);

        addToBot(new GainBlockAction(AbstractDungeon.player, block));
    }
}
