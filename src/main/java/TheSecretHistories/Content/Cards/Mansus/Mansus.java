package TheSecretHistories.Content.Cards.Mansus;

import TheSecretHistories.Content.Cards.Template.TemplateMultiLevelCard;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerColorEnum.CULT_BLUE;

public class Mansus extends TemplateMultiLevelCard {

    public static final String ID = StringUtils.MakeID(Mansus.class.getSimpleName());

    private static final int COST = 0;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardColor COLOR = CULT_BLUE;
    private static final CardRarity RARITY = CardRarity.SPECIAL;
    private static final CardTarget TARGET = CardTarget.NONE;

    /*
    * 林地：2 级影响，2~4 级秘史
    * 林地（飞蛾：蛾） 井（圣杯、丝绒：杯、心、蛾） 转轮之寺（转轮：心、启）
    * 纯白之门：6 级影响，4~6 级秘史，随机信徒
    * 纯白之门（冬、亡者） 睿智骑士小屋（特蕾莎：灯、启） 光之果园（弧月、残阳：灯、心）
    * 牡鹿之门：10 级影响，6~8 级秘史，随机赞助人
    * 牡鹿之门（格里比：启、铸） 画中之河（知识、入迷、秘史） 利刃阶梯（冬、刃、杯）
    * 蜘蛛之门：10~15 级影响，8~10 级秘史，赤化精华+
    * 蜘蛛之门（杯、心、人情） 锤炼场（15铸、灯、赤化精华） 聚点（启、灯、冬、蛾、入迷）
    * 孔雀之门：15 级影响，10~12 级秘史，不凋花蜜+ 【镜子/碎门之钥】
    * 孔雀之门（知识、15灯、入迷） 赤红教堂（15杯、不凋花蜜） 蠕虫展馆（15冬、恐惧）
    *
    * */


    public Mansus() {
        super(ID, COST, TYPE, COLOR, RARITY, TARGET, 4);
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {

    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {

    }

    public void onRemoveFromMasterDeck() {
        AbstractDungeon.player.masterDeck.addToHand(makeCopy());
    }

    public void triggerOnExhaust() {
        addToBot(new MakeTempCardInHandAction(makeCopy()));
    }
}
