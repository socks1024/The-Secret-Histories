package TheSecretHistories.Content.Cards.FITIF.Fragments;

import TheSecretHistories.Content.Actions.UniqueCards.UpgradeByTagAction;
import TheSecretHistories.Content.Actions.UniqueCards.UpgradeRandomCardByTagAction;
import TheSecretHistories.Content.Cards.Template.TemplateCustomCard;
import TheSecretHistories.Utils.DebugUtils;
import TheSecretHistories.Utils.DeckUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.ArrayList;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.FRAGMENT;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.MOTH;

public class FragmentMoth extends AbstractFragment{

    public static String ID = StringUtils.MakeID(FragmentMoth.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = MOTH;

    public FragmentMoth() {
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

        for (int i = 0; i < magicNumber; i++){
            addToBot(new UpgradeByTagAction(abstractPlayer, FRAGMENT, DeckUtils.GetBattleDeck()));
        }
    }
}
